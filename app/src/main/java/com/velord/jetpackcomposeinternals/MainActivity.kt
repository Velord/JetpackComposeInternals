package com.velord.jetpackcomposeinternals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.velord.jetpackcomposeinternals.ui.component.Greeting
import com.velord.jetpackcomposeinternals.ui.theme.MainTheme
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainTheme {
        Greeting("Android")
    }
}

typealias Adder = (Int, Int) -> (Int)

val add: Adder = { a, b ->
    a + b
}

fun (Adder).logged(): (Adder) = { a, b ->
    println("Adding $a and $b")
    this(a, b)
}
fun main() = runBlocking {
    val loggedAdd = add.logged()
    println(loggedAdd(1, 2))
}