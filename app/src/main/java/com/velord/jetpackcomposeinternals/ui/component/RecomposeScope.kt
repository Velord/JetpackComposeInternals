package com.velord.jetpackcomposeinternals.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope

data class User(val name: String)

interface Presenter {
    fun loaduser(after: @Composable () -> Unit): User
}

@Composable
fun Test(presenter: Presenter) {
    val user = presenter.loaduser {
        currentRecomposeScope.invalidate()
    }
    Text(text = user.name)
}