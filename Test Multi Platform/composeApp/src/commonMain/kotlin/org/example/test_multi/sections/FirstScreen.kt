package org.example.test_multi.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object FirstScreen {
    @Composable
    fun MainScreen(
        modifier: Modifier,
        toSecondScreen: () -> Unit
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 4.dp,
                alignment = Alignment.CenterVertically
            ),
            content = {
                Text(text = this@FirstScreen::class.simpleName.toString())
                Button(
                    onClick = toSecondScreen,
                    content = { Text(text = "navigate to screen 2") }
                )
            }
        )
    }
}