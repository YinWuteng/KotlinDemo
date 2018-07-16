package com.kotlindemo.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gyf.barlibrary.ImmersionBar
import com.kotlindemo.R
import com.kotlindemo.base.BaseActivity
import com.kotlindemo.ui.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * Create By yinwuteng
 * 2018/7/5.
 */
class MainActivity : BaseActivity(),View.OnClickListener {

    var homeFragment: HomeFragment? = null
    var findFragment: FindFragment? = null
    var hotFragment: HotFragment? = null
    var mineFragment: MineFragment? = null
    var mExitTime: Long = 0
    var toast: Toast? = null
    lateinit var searchFragment: SearchFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //沉寂栏
        ImmersionBar.with(this).transparentBar().barAlpha(0.3f).fitsSystemWindows(true).init()
        val window = window
        val params = window.attributes
        params.systemUiVisibility = View
                .SYSTEM_UI_FLAG_HIDE_NAVIGATION
        window.attributes = params
        setRadioButtom()
        initToolbar()
        initFragment()
    }


    private fun initToolbar() {
        var today = getToday()
        tv_bar_title.text = today
        tv_bar_title.typeface = Typeface.createFromAsset(this.assets, "fonts/Lobster-1.4.otf")
        iv_search.setOnClickListener {
            if (rb_mine.isChecked) {

            } else {
                searchFragment = SearchFragment()
                searchFragment.show(fragmentManager,SEARCH_TAG)
            }
        }
    }

    private fun getToday(): String {
        var list = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        var data: Date = Date()
        var calendar: Calendar = Calendar.getInstance()
        calendar.time = data
        var index: Int = calendar.get(Calendar
                .DAY_OF_WEEK - 1)
        if (index < 0) {
            index = 0
        }
        return list[index]
    }

    private fun initFragment() {

    }

    private fun setRadioButtom() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

