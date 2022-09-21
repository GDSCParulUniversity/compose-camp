package journey.started.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import journey.started.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   ComposeTask(name = "Vaibhav Patil")
                }
            }
        }
    }
}

@Composable
fun ComposeTask(name: String) {
    Column(modifier = Modifier
        //.fillMaxWidth()
       //.fillMaxHeight()
    , horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement = Arrangement.Center
        ) {
            val image = painterResource(R.drawable.composelogo2)
            val heartImage = painterResource(R.drawable.heart)
            val myImage = painterResource(id = R.drawable.my_image)

        Image(painter = image, contentDescription = null, Modifier.size(280.dp))
        Text(text = name, color = colorResource(id = R.color.name_color), fontSize = 24.sp)
        Image(painter = heartImage, contentDescription = null)
        Text(text = stringResource(id = R.string.main), fontSize = 35.sp,
            color = colorResource(id = R.color.jetpack_compose_color))
    }
}
@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
       //ComposeTask(name = "Vaibhav Patil")
    }
}