package org.example.test_multi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen.MainScreen()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    HomeScreen.MainScreen()
}

actual fun getCar() = Car(
    name = "BMW",
    price = 100_000f,
    horsePower = 800,
    isElectric = false
)

actual object FunctionCollections {
    actual fun testFunctionOne() {
        TODO()
    }
}