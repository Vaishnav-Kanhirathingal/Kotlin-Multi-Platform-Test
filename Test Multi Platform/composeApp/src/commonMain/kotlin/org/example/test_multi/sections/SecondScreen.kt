package org.example.test_multi.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object SecondScreen {
    @Composable
    fun MainScreen(
        modifier: Modifier,
        navigateBack: () -> Unit
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 4.dp,
                alignment = Alignment.CenterVertically
            ),
            content = {
                Text(text = this@SecondScreen::class.simpleName.toString())
                Button(
                    onClick = navigateBack,
                    content = { Text(text = "navigate to screen 1") }
                )
            }
        )
    }
}