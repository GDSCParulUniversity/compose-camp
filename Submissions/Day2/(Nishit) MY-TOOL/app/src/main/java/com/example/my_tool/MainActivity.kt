package com.example.my_tool

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_tool.ui.theme.MYTOOLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MYTOOLTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MYTOOLTheme {
  Box(modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
      ) {
      Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
      ){
          Image(
              painter = painterResource(id = R.drawable.jetpack),
              contentDescription = null,
              Modifier.size(300.dp)
          )
          Text(text = "Dare-Devil", fontSize = 50.sp,)
          Image(
              painter = painterResource(id = R.drawable.download),
              contentDescription = null,
              Modifier.size(160.dp)
          )
          Text(text = "Compose", fontSize = 50.sp,)
      }

  }
    }
}



