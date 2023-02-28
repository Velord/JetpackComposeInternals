package com.velord.jetpackcomposeinternals.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable

@Composable
@NonRestartableComposable
fun ConditionalText(a: Boolean, b: String) {
    if (a) {
        Text(a.toString())
    } else {
        Text(b)
    }
}