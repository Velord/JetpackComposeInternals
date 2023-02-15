package com.velord.jetpackcomposeinternals.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NamePlate(name: String) {
    val name = remember { name }
    Text(text = name)
}

@NonRestartableComposable
@Composable
fun NamePlate(name: String, lastName: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = name)
        Text(text = lastName, style = MaterialTheme.typography.subtitle1)
    }
}

data class Talk(val id: Int)