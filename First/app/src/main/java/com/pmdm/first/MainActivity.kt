package com.pmdm.first

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pmdm.first.ui.theme.FirstTheme

class MainActivity : ComponentActivity() {

    private var pauseStart : Long = 0
    private var pausedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("STATUS", "ON CREATE")
        enableEdgeToEdge()
        setContent {
            FirstTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "WORLD",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("STATUS", "ON START")

    }

    override fun onResume(){
        super.onResume()
        Log.d("STATUS", "ON RESUME")

        if(pauseStart != 0L){
            val pauseDuration = System.currentTimeMillis() - pauseStart
            pausedTime += pauseDuration
            Log.d("STATUS", "Tiempo en pausa: ${pauseDuration / 1000} segundos")
            Toast.makeText(this, "${pausedTime}", Toast.LENGTH_SHORT).show()
            pauseStart = 0L // RESTART TIME
        }

    }

    override fun onPause() {
        super.onPause()
        Log.d("STATUS", "ON PAUSE")
        pauseStart = System.currentTimeMillis()

    }

    override fun onStop() {
        super.onStop()
        Log.d("STATUS", "ON STOP")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("STATUS", "ON RESTART")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("STATUS", "ON DESTROY")

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstTheme {
        Greeting("Android")
    }
}