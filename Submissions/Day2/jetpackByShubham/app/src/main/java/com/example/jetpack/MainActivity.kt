package com.example.jetpack

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
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
import com.example.jetpack.ui.theme.JetpackTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackTheme {
        Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center)
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//Jet pack Logo
                Image(
                    painter = painterResource(id = R.drawable.jetpack),
                    contentDescription = "ComposeLogo",
                    modifier = Modifier.size(250.dp)
                )
                Text(text = "Shubham Singh")
                //Hear Logo
                Image(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "HeartLogo",
                    modifier = Modifier.size(250.dp)
                )
                Text(text = "Jetpack Compose", color = Color.Blue )
            }


        }
    }
}
