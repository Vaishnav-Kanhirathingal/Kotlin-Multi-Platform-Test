package org.example.test_multi

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

fun MainViewController() = ComposeUIViewController {
    val root = createRootComponent()
    HomeScreen.MainScreen(root = root)
}

fun createRootComponent(): RootComponent {
    val lifecycle = LifecycleRegistry()
    return RootComponent(DefaultComponentContext(lifecycle))
}