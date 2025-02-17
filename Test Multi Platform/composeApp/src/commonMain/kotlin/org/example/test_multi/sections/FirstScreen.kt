package org.example.test_multi.sections

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

object FirstScreen {
    @Composable
    fun MainScreen(toSecondScreen: () -> Unit) {
        Text(text = this::class.simpleName.toString())
        Button(
            onClick = toSecondScreen,
            content = {
                Text(text = "navigate to screen 2")
            }
        )
    }
}