package com.kotlindemo.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create By yinwuteng
 * 2018/7/5.
 */
fun Context.showToast(message:String):Toast{
    var toast:Toast= Toast.makeText(this,message,Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.CENTER,0,0)
    toast.show()
    return toast
}

/***
 * activity跳转
 */
inline fun <reified T : Activity> Activity.newIntent() {
val intent=Intent(this,T::class.java)
    startActivity(intent)
}

fun <T> Observable<T>.applySchedulers():Observable<T>{
    return subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}