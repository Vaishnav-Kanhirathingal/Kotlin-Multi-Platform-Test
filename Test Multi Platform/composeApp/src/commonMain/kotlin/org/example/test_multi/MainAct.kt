package org.example.test_multi

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.backStack
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import org.example.test_multi.sections.FirstScreen
import org.example.test_multi.sections.SecondScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

object HomeScreen {
    @Composable
    @Preview
    fun MainScreen(root: RootComponent) {
        MaterialTheme {
//            TestingScreen.MainScreen()
            App(root = root)
        }
    }

    @Composable
    fun App(root: RootComponent) {
        val childStack = root.childStack.subscribeAsState()
        when (val screen = childStack.value.active.instance) {
            is AppScreen.One -> {
                FirstScreen.MainScreen(
                    toSecondScreen = { root.navigateTo(screen = AppScreen.Two()) }
                )
            }

            is AppScreen.Two -> {
                SecondScreen.MainScreen(
                    navigateBack = { root.navigateTo(screen = AppScreen.One()) }
                )
            }
        }
    }
}

@Serializable
sealed class AppScreen {
    @Serializable
    class One(val id: Int = 0) : AppScreen()

    @Serializable
    class Two(val id: Int = 0) : AppScreen()
}

//sealed class ScreenConfig {
//    data object One : ScreenConfig()
//    data class Two(val id: String) : ScreenConfig()
//}

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<AppScreen>()

    val childStack: Value<ChildStack<AppScreen, AppScreen>> =
        childStack(
            source = navigation,
            initialConfiguration = AppScreen.One(),
            handleBackButton = true,
            childFactory = ::createScreen,
            serializer = AppScreen.serializer()
        )

    private fun createScreen(screen: AppScreen, context: ComponentContext): AppScreen =
        screen

    @OptIn(DelicateDecomposeApi::class)
    fun navigateTo(screen: AppScreen) {
        navigation.push(screen)
    }

    fun navBack(): Boolean {
        if (childStack.backStack.isNotEmpty()) {
            navigation.pop()
            return true
        } else {
            return false
        }
    }
}