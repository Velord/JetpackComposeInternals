package com.velord.jetpackcomposeinternals.ui.component

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.*

@Composable
fun Block() {

}

@Composable
fun TestTry() {
//    try {
//        Block()
//    } catch (e: Exception) {
//
//    }  error !
}

@Composable
fun Disallow(
    f: @DisallowComposableCalls () -> Unit
) {
    f()
}

@Composable
fun TestDisallow () {
    Disallow {
       // ReadOnly()  error !
    }
}

@ReadOnlyComposable
@Composable
fun TestReadOnly() {
     //ReadOnly()
    // error !
}

@Composable
fun ReadOnly() {
}

@Composable
fun backPressHandler(
    enabled: Boolean = true,
    onBackPressed: () -> Unit
) {
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }
    }

    DisposableEffect(key1 = dispatcher) {
        dispatcher?.addCallback(backCallback)
        onDispose {
            backCallback.remove()
        }
    }
}

@Composable
fun TestDisposableEffect() {
    backPressHandler {

    }
}