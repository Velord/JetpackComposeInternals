package com.velord.jetpackcomposeinternals.ui.screen

import androidx.annotation.StringRes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
inline fun MyComposable(@StringRes nameResId: Int, resolver: (Int) -> String) {
    val name = resolver(nameResId)
    Text(name)
}

@Composable
fun InlineScreen() {
    // lambda with @Composable annotation produce "Backend Internal error: Exception during IR lowering"
//    MyComposable(nameResId = R.string.app_name) @Composable {
//        LocalContext.current.resources.getString(it)
//    }
}