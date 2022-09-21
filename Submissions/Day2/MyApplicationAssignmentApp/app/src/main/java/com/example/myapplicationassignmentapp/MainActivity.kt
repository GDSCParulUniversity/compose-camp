package com.example.myapplicationassignmentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import com.example.myapplicationassignmentapp.ui.theme.MyApplicationAssignmentAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationAssignmentAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FirstPage("Virender Singh Rathore")
                }
            }
        }
    }
}

@Composable
fun FirstPage(name: String){
    Column(
        modifier = Modifier ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center
        ) {
        Image(painter = painterResource(id = R.drawable.jetpack_image) ,
            modifier = Modifier.size(280.dp),
            contentDescription = "Compose Image" )
        Text(text = name ,
            color = colorResource(id = R.color.name_color),
            fontSize = 28.sp)
        Image(painter = painterResource(id = R.drawable.heart) ,
            modifier = Modifier.size(120.dp),
            contentDescription = "Heart Image" )
        Text(text = "Jetpack Compose",
            color = colorResource(id = R.color.jetpack_compose_colour),
            fontSize = 32.sp)

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationAssignmentAppTheme {
    // FirstPage("Virender Singh Rathore")
    }
}