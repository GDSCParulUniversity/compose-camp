package com.example.myapplication

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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {


    MyApplicationTheme {
        Box(modifier = Modifier.fillMaxSize()
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Image(painter = painterResource(id =R.drawable.jetpack_compose_icon), contentDescription = "loops",
                    modifier = Modifier.size(200.dp))
                Text(text = "Jetpacks",
                    fontSize = 13.sp)
                Image(painter = painterResource(id =R.drawable.heart), contentDescription = "heart",
                    modifier = Modifier.size(150.dp))
                Text( text = "Sakendra Soni")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {


    MyApplicationTheme {
        Box(modifier = Modifier.fillMaxSize()
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(painter = painterResource(id =R.drawable.jetpack_compose_icon), contentDescription = "loops",
                    modifier = Modifier.size(200.dp))
                    Text(text = "Jetpacks",
                    fontSize = 13.sp)
                    Image(painter = painterResource(id =R.drawable.heart), contentDescription = "heart",
                    modifier = Modifier.size(150.dp))
                    Text( text = "Sakendra Soni")
                    }
    }
}
}