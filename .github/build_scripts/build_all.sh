#!/bin/bash

set -e

_c_green="\e[32m"
_c_red="\e[31m"
_c_blue="\e[34m"
RST="\e[0m"

git_top_level=$(git rev-parse --show-toplevel)
launch_pad="${git_top_level}/out"


die()    { echo -e "${_c_red}[E] ${*}${RST}";exit 1;:;}
warn()   { echo -e "${_c_red}[W] ${*}${RST}";:;}
shout()  { echo -e "${_c_blue}[-] ${*}${RST}";:;}
success(){ echo -e "${_c_green}[+] ${*}${RST}";:;}
lshout() { echo -e "${_c_blue} ${*}${RST}";:;}
msg()    { echo -e "${*} \e[0m" >&2;:;}

# Check for java installation
if command -v java; then
  success "Java is installed"
else
  die "Java is not installed"
  exit 1
fi

# function is_valid_project to check is folder contains valid android project
function is_valid_project() {
  local project_name=$1
  local project_path="${git_top_level}/${project_name}"

  [[ -d "${project_path}" ]] && {
    if [[ -d "${project_path}/app" ]] && [[ -f "${project_path}/gradlew" ]]; then
      return 0
    else
      return 1
    fi
  }

}

function build() {
  project_name=$(basename "$1")
  project_path="$1"
  out_dir="${launch_pad}/${project_name}"

  [[ ! -d $out_dir ]] && mkdir -p "$out_dir"

  shout "Building ${project_name}..."
  cd "${project_path}" || msg "cd failed"
  # Execute gradle build
  bash gradlew build

  cd ${git_top_level} || msg "cd failed"
  
  # copy built applications to $launch_pad directory
  cp -rv \
    "$project_path"/app/build/outputs/apk/debug \
    "$out_dir"
  
  # Zip the apk and metadata
  zip -r -j \
    "${launch_pad}/${project_name}.zip" \
    "$out_dir"
  
  success "Build  Pack successful"
}

function cleanup() {
  shout "Cleaning up..."
  rm -rf "${launch_pad}"
  success "Cleanup successful"
}

trap 'cleanup; exit 1;' HUP INT TERM

[[ ! -d $launch_pad ]] && mkdir "$launch_pad"

# Decorator function to show buildable projects
while IFS= read -r -d '' folder; do
  if is_valid_project "${folder}"; then
    shout "Found project: ${folder}"
  fi
done < <(find . ./Submissions -maxdepth 2 -type d -print0)

lshout "Building all projects.."

OIFS="$IFS"
IFS=$'\n'
for folder in $(find . ./Submissions -maxdepth 2 -type d); do
  if ! is_valid_project "${folder}"; then
    msg "Skipping ${folder}"
      continue
  else
    build "${folder}"
  fi
done

# Export out dir to githubenv
echo "OUT_DIR=${launch_pad}" >> $GITHUB_ENV

success "Script completed.."
