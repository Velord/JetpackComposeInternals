package com.velord.jetpackcomposeinternals.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

interface FileReaderScope {
    fun onFileOpen()
    fun onFileClosed()
    fun onLineRead(line: String)
}

object Scope: FileReaderScope {
    override fun onFileOpen() = TODO()
    override fun onFileClosed() = TODO()
    override fun onLineRead(line: String) = TODO()
}

@Composable
fun FileReader(path: String, content: @Composable FileReaderScope.(path: String) -> Unit) {
    // with @Composable no error
    // without Kotlin does not allow named arguments
    Column {
        Scope.content(path = path)
    }
}