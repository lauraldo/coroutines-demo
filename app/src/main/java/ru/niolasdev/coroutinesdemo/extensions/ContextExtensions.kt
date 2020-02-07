package ru.niolasdev.coroutinesdemo.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

inline fun <reified T : Activity> Context?.startActivity() =
    this?.startActivity(Intent(this, T::class.java))

inline fun <reified T : Activity> Context?.startActivity(extras: Bundle?): Unit? {
    val intent = Intent(this, T::class.java)
    extras?.let { intent.putExtras(it) }
    return this?.startActivity(intent)
}