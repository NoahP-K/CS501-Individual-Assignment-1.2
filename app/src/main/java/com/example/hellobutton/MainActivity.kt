package com.example.hellobutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hellobutton.ui.theme.HelloButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloButtonTheme {
                //Creates a gray screen-width column at the top of the screen with
                // a button centered inside.
                Column(modifier = Modifier.fillMaxWidth()
                    .background(Color.Gray)
                    .padding(top = 64.dp, bottom = 64.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ButtonPress()
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello there $name!",
        modifier = modifier
    )
}

@Composable
fun MakeButton(observer: MutableState<Boolean>, modifier: Modifier = Modifier) {
    Button(onClick = { observer.value = true }, modifier = modifier)
    {
        Text("Press me!")
    }
}

@Composable
fun ButtonPress(modifier: Modifier = Modifier) {
    //This function makes the button and the mutable state boolean that it changes.
    //Then it checks the value of the mutable state and creates the text if needed.
    var observer = remember { mutableStateOf(false) }
    MakeButton(observer, modifier)
    if (observer.value) {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloButtonTheme {
        Greeting("Android")
    }
}