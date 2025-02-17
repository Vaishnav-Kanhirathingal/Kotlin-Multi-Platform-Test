package org.example.test_multi.sections

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.example.test_multi.Greeting
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import testmultiplatform.composeapp.generated.resources.Res
import testmultiplatform.composeapp.generated.resources.compose_multiplatform
import testmultiplatform.composeapp.generated.resources.egypt
import testmultiplatform.composeapp.generated.resources.france
import testmultiplatform.composeapp.generated.resources.indonesia
import testmultiplatform.composeapp.generated.resources.japan
import testmultiplatform.composeapp.generated.resources.mexico

object TestingScreen {
    @Composable
    fun MainScreen() {
        val list = listOf(
            ImageCombo(name = "egypt", res = Res.drawable.egypt),
            ImageCombo(name = "france", res = Res.drawable.france),
            ImageCombo(name = "indonesia", res = Res.drawable.indonesia),
            ImageCombo(name = "japan", res = Res.drawable.japan),
            ImageCombo(name = "mexico", res = Res.drawable.mexico)
        )
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
            val index = remember { mutableStateOf(0) }

            Image(
                painter = painterResource(resource = list.get(index = index.value).res),
                contentDescription = null
            )
            Text(text = list.get(index = index.value).name)
            Button(
                onClick = {
                    index.value = index.value.inc().takeUnless { it > list.lastIndex } ?: 0
                },
                content = { Text(text = "Switch Country") }
            )

        }
    }
}

private class ImageCombo(
    val name: String,
    val res: DrawableResource
)
