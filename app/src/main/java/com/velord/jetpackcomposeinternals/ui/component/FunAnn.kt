package com.velord.jetpackcomposeinternals.ui.component

@Target(AnnotationTarget.FUNCTION)
annotation class FunAnn

inline fun myFun(a: Int, f: (Int) -> String): String = f(a)

fun main() {
    // myFun(1) @FunAnn { it.toString() }
    // The lambda expression here is an inlined argument so this annotation cannot be stored anywhere
}