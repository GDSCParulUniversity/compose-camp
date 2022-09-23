package com.example.meditationapp.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.internal.illegalDecoyCallException
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationapp.R
import java.util.*

@Composable
fun HomeScreen () {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(DeepBlue)) {

        Column {
            GreetingSection()
            val scrolllist = mutableListOf<String>("Sound Sleep","Insomnia","Depression","Aashiqui")
            chipSection(chips = scrolllist)
            ThirdSection()
            FourthSection()
            FifthSection(properties = listOf(
                GridProperties(
                    title = "Sleep Meditation",
                    Icon = R.drawable.ic_music,
                    squareColor = BlueViolet2
                ),GridProperties(
                    title = "Tips for Sleeping",
                    Icon = R.drawable.ic_videocam,
                    squareColor = LightGreen2
                ),GridProperties(
                    title = "Night island",
                    Icon = R.drawable.ic_moon,
                    squareColor = OrangeYellow3
                ),GridProperties(
                    title = "Calming sounds",
                    Icon = R.drawable.ic_headphone,
                    squareColor = Beige2
                )
            )
            )
        }
        BottomBar(list = listOf(
            BottomBarItemsProperties("Home" , R.drawable.ic_home),
            BottomBarItemsProperties("Meditate" , R.drawable.ic_bubble),
            BottomBarItemsProperties("Sleep" , R.drawable.ic_moon),
            BottomBarItemsProperties("Music" , R.drawable.ic_music),
            BottomBarItemsProperties("Profile" , R.drawable.ic_profile)
        ),modi = Modifier.align(BottomCenter))
    }
}

@Composable
fun GreetingSection(){

    var updatedtext = GreetingUpdate()

    Row(
        horizontalArrangement = Arrangement.SpaceBetween ,
        verticalAlignment = Alignment.CenterVertically ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "$updatedtext , Virender",
                color = TextWhite ,
                style = MaterialTheme.typography.h5)

            Text(text = "We wish you a great day",
                color = TextWhite ,
                style = MaterialTheme.typography.body1)
        }
        Icon(painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search" ,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

    }

}


fun GreetingUpdate():String {
    val c = Calendar.getInstance()
    var timeofDay = c.get(Calendar.HOUR_OF_DAY)

    return when (timeofDay) {
        in 0..11 -> "Good Morning"
        in 12..15 -> "Good Afternoon"
        in 16..20 -> "Good Evening"
        in 21..24 -> "Good Night"
        else -> "Time is not correct"
    }
}

@Composable
fun chipSection(
    chips: List<String>
){

    var SelectedchipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow{
        items(chips.size){
            Box(modifier = Modifier
                .padding(start = 15.dp, top = 15.dp, bottom = 15.dp, end = 4.dp)
                .clickable {
                    SelectedchipIndex = it
                }
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (SelectedchipIndex == it) ButtonBlue
                    else DarkerButtonBlue
                )
                .padding(15.dp)
                ){
                Text(text = chips[it])
            }
        }
    }
}

@Composable
fun ThirdSection(){

    Row(
        horizontalArrangement = Arrangement.SpaceBetween ,
        verticalAlignment = Alignment.CenterVertically ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(LightRed)
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Daily Thought",
                color = TextWhite ,
                style = MaterialTheme.typography.h5)

            Text(text = "Meditation 3 - 10min",
                color = TextWhite ,
                style = MaterialTheme.typography.body1)
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clickable {  }
                .clip(CircleShape)
                .background(ButtonBlue)
        ){
            Icon(painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "search" ,
                tint = Color.White,
                modifier = Modifier.size(16.dp))
        }

    }

}

@Composable
fun FourthSection(){
    Box(contentAlignment = Alignment.CenterStart,
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .clip(RoundedCornerShape(14.dp))){
     
        Text(text = "Featured",
        color = TextWhite,
            style = MaterialTheme.typography.h5)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FifthSection(properties: List<GridProperties>){
  LazyVerticalGrid(cells = GridCells.Fixed(2),
      contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp ),
      modifier = Modifier.fillMaxHeight()
  ){
      items(properties.size){
          SquareContents(values = properties[it])
      }
  }
}

@Composable
fun SquareContents(values: GridProperties){
   BoxWithConstraints(modifier = Modifier
       .padding(7.5.dp)
       .aspectRatio(1f)
       .clip(RoundedCornerShape(10.dp))
       .background(values.squareColor)
   ) {
       val width = constraints.maxWidth
       val height = constraints.maxHeight
       
       Box(modifier = Modifier
           .padding(16.dp)
           .fillMaxSize()){

           Text(text = values.title , style = MaterialTheme.typography.h6,
               lineHeight = 26.sp, modifier = Modifier.align(Alignment.TopStart),
               color = TextWhite
           )
           Icon(painter = painterResource(id = values.Icon),
               contentDescription = "Music",
               modifier = Modifier.align(Alignment.BottomStart),
               tint = TextWhite
           )
           Text("Start",
           fontSize = 14.sp,
           color = TextWhite,
           fontWeight = FontWeight.Bold,
           modifier = Modifier
               .clickable {

               }
               .align(Alignment.BottomEnd)
               .clip(RoundedCornerShape(12.dp))
               .background(ButtonBlue)
               .padding(horizontal = 16.dp, vertical = 6.dp))
           }
       }
   }

@Composable
fun BottomBar(list: List<BottomBarItemsProperties>,
              modi: Modifier = Modifier,
              selectColor: Color = ButtonBlue,
              selecttextColor: Color = Color.White,
              unselecttextColour: Color = AquaBlue,
              initialselectIndex: Int = 0
              ){
    var selectedMenuIndex by remember {
        mutableStateOf(initialselectIndex)
    }
    Row (
        horizontalArrangement = Arrangement.SpaceAround ,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modi
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(top = 16.dp, bottom = 16.dp)
    ){
        list.forEachIndexed{
                index ,item ->
            BottomBarMenuItems(values = item,
                isSelected = selectedMenuIndex == index
            ) {

                selectedMenuIndex = index
            }
        }
    }
}

@Composable
fun BottomBarMenuItems(values: BottomBarItemsProperties,
                       isSelected: Boolean = false,
                       modifier: Modifier = Modifier,
                       selectColor: Color = ButtonBlue,
                       selecttextColor: Color = Color.White,
                       unselecttextColour: Color = AquaBlue,
                       onClick: () -> Unit
){
  Column(horizontalAlignment = Alignment.CenterHorizontally,
  verticalArrangement = Arrangement.Center,
  modifier = Modifier.clickable { onClick() }) {

      Box(contentAlignment = Alignment.Center,
      modifier = Modifier
          .clip(RoundedCornerShape(10.dp))
          .background(if (isSelected) ButtonBlue else Color.Transparent)
          .padding(10.dp)){
          
          Icon(painter = painterResource(id = values.icon),
              contentDescription = values.iconname,
              tint = if (isSelected) selecttextColor else unselecttextColour,
              modifier = Modifier.size(20.dp)
              )
      }
      Text(text = values.iconname,
      color = if (isSelected) selecttextColor else unselecttextColour
          )
  }
}