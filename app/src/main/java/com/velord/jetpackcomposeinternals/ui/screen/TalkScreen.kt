package com.velord.jetpackcomposeinternals.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import com.velord.jetpackcomposeinternals.ui.component.Talk

@Composable
fun TalkScreen(talks: List<Talk>) {
    Column {
        talks.forEach {
            key(it.id) {
                Talk(it)
            }
        }
    }
}

@Composable
private fun Talk(value: Talk) {

}