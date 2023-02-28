package com.velord.jetpackcomposeinternals.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.ReadOnlyComposable

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