package com.velord.jetpackcomposeinternals.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

@Composable
fun SearchScreen() {
    val scope = rememberCoroutineScope()
    val currentJobState = remember { mutableStateOf<Job?>(null) }
    val itemsState = remember { mutableStateOf<List<String>>(emptyList()) }

    Column {
        Row {
            TextField(
                value = "Start typing to search",
                onValueChange = { newVlaue ->
                    currentJobState.value?.cancel()
                    currentJobState.value = scope.async {
                        delay(500)
                        val items =  itemsState.value.filter { it.contains(newVlaue) }
                        itemsState.value = items
                    }
                }
            )
        }
        Row {
           // ItemsVertical(itemsState.value)
        }
    }
}

data class Speaker(val id: Int, val name: String)

@Composable
fun SearchScreen(eventId: Int) {
    val uiState = produceState(initialValue = emptyList<Speaker>(), key1 = eventId) {
        val speakers = listOf<Speaker>()
        value = speakers
    }
}