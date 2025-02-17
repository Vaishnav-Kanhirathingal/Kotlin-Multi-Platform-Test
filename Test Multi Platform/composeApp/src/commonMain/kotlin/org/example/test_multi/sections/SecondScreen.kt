package org.example.test_multi.sections

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

object SecondScreen {
    @Composable
    fun MainScreen(navigateBack: () -> Unit) {
        Text(text = this::class.simpleName.toString())
        Button(
            onClick = navigateBack,
            content = { Text(text = "navigate to screen 1") }
        )
    }
}