package com.pmdm.happybirthday

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingWithButton(
                        modifier = Modifier.padding(innerPadding),
                        message = "Happy Birthday Sam!",
                        from = "From Emma"
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingWithButton(message: String, from: String, modifier: Modifier = Modifier) {
    var counter : Int by remember { mutableStateOf(0) }
    var textColor: Color by remember { mutableStateOf(Color.Black) }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center

        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
            
        )
        Button(
            onClick = {
                // Cambiar el contador al hacer clic en el botón
                counter++;

                Log.d("BOTON", "CLICK")
            },

            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Contador = $counter")
        }
    }
    Row {
        Botones()
    }

}

@Composable
fun Botones() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxWidth()
    ){
        Button(onClick = {}){Text("Button 1")}
        Button(onClick = {}){Text("Button 2")}
        Button(onClick = {}){Text("Button 3")}
        Button(onClick = {}){Text("Button 4")}
    }
}


@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview(){
    HappyBirthdayTheme {
        GreetingWithButton(message = "Happy Birthday Sam!", from = "From Emma")
    }
}



