package com.example.jetpacklogoapp

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacklogoapp.ui.theme.JetpackLogoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackLogoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                 FirstPage()
                }
            }
        }
    }
}
@Composable
fun FirstPage(){
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.jetpack),
            modifier = Modifier.size(130.dp),
            contentDescription = "Jetpack pic"
        )
        Text(
            text = "Vinayak Gupta",
            color = colorResource(id = R.color.name),
            fontSize = 15.sp
        )
        Image(
            painter = painterResource(id = R.drawable.heart1),
            modifier = Modifier.size(120.dp),
            contentDescription = "Heart"
        )
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackLogoAppTheme {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.jetpack),
                  modifier = Modifier.size(130.dp),
                  contentDescription = "Jetpack pic")
            Text(text = "Vinayak Gupta",
            color= colorResource(id = R.color.name),
            fontSize = 15.sp)
            Image(painter = painterResource(id = R.drawable.heart1),
                modifier = Modifier.size(120.dp),
                contentDescription = "Heart")

        }
    }
}