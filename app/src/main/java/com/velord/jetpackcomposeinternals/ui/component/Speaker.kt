package com.velord.jetpackcomposeinternals.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

data class Speaker(val id: Int, val name: String)

@Composable
fun SpeakerList(speakers: List<Speaker>) {
    Column {
        speakers.forEach {
            Speaker(it)
        }
    }
}

@Composable
private fun Speaker(data: Speaker) {
    Text(text = data.name)
}