package org.example.test_multi

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.example.test_multi.sections.TestingScreen
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.ui.tooling.preview.Preview

object HomeScreen {
    @Composable
    @Preview
    fun MainScreen() {
        MaterialTheme {
            TestingScreen.MainScreen()
        }
    }
}

class ImageCombo(
    val name: String,
    val res: DrawableResource
)
