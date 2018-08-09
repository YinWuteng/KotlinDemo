package com.kotlindemo.ui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

/**
 * Create By yinwuteng
 * 2018/7/23.
 */
class VideoDetailActivity : AppCompatActivity() {
    companion object {
        var MSG_IMAGE_LOADED = 101
    }

    var mContext: Context = this
    lateinit var imageView: ImageView
    var isPlay: Boolean = false
    var isPause: Boolean = false

}