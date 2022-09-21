package com.example.gdsc
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gdsc.ui.theme.GDSCTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDSCTheme {
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.jetpack), contentDescription = null)
                    Text(text = "harsh Surani", fontSize = 30.sp, color = colorResource(id = R.color.Name))
                    Image(painter = painterResource(id = R.drawable.heart), contentDescription = null)
                    Text(text = "Jetpack Compose", fontSize = 40.sp, color = colorResource(id = R.color.Jetpack_Compose))
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GDSCTheme {
            Box(modifier = Modifier.fillMaxSize()){
                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.jetpack), contentDescription = null, Modifier.size(130.dp))
                    Text(text = "Harsh Surani", fontSize = 30.sp, color = Color.Blue)
                    Image(painter = painterResource(id = R.drawable.heart), contentDescription = null, Modifier.size(60.dp))
                    Text(text = "Jetpack Compose", fontSize = 40.sp)
                }
            }

    }
}