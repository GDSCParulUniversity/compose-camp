package com.arbaz.composeact

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arbaz.composeact.ui.theme.ComposeactTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeactTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.compose), contentDescription ="logo",
                                modifier = Modifier.size(200.dp))
                            Text(text = "Arbaz Malek",
                                fontSize = 30.sp)
                            Image(painter = painterResource(id = R.drawable.heartpng,), contentDescription = "heart",
                                modifier = Modifier.size(100.dp))
                            Text(text = "JetPack compose",
                                fontSize = 35.sp,
                                color = Color.Blue)
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeactTheme {

        Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.compose), contentDescription ="logo",
                    modifier = Modifier.size(200.dp))
                Text(text = "Arbaz Malek",
                    fontSize = 30.sp)
                Image(painter = painterResource(id = R.drawable.heartpng,), contentDescription = "heart",
                    modifier = Modifier.size(100.dp))
                Text(text = "JetPack compose",
                    fontSize = 35.sp,
                    color = Color.Blue)
            }
        }


        }



    }
