package com.kotlindemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


abstract
/**
 * Create By yinwuteng
 * 2018/7/5.
 * 基类activity
 */
class  BaseActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}