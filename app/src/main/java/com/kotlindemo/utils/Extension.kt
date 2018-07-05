package com.kotlindemo.utils

import android.app.Activity
import android.content.Intent

/**
 * Create By yinwuteng
 * 2018/7/5.
 */

/***
 * activity跳转
 */
inline fun <reified T : Activity> Activity.newIntent() {
val intent=Intent(this,T::class.java)
    startActivity(intent)
}