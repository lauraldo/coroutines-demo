package ru.niolasdev.coroutinesdemo.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.formatBrief(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    return sdf.format(this)
}