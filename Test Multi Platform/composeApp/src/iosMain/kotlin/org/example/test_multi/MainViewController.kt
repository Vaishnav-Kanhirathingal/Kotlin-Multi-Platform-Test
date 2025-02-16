package org.example.test_multi

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { HomeScreen.MainScreen() }

actual fun getCar() = Car(
    name = "Merc",
    price = 80_000f,
    horsePower = 600,
    isElectric = true
)

actual object FunctionCollections {
    actual fun testFunctionOne() {
        TODO()
    }
}