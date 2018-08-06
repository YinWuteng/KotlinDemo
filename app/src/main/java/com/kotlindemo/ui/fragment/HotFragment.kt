package com.kotlindemo.ui.fragment

import android.app.Fragment
import com.kotlindemo.R
import com.kotlindemo.base.BaseFragment

/**
 * Create By yinwuteng
 * 2018/7/16.
 */
class HotFragment : BaseFragment() {
    var mTabs = listOf<String>("周排行", "月排行", "总排行").toMutableList()
    lateinit var mFragments: ArrayList<Fragment>
    val STRATEGY = arrayOf("weekly", "monthly", "historical")
    override fun getLayoutResources(): Int {
        return R.layout.hot_fragment
    }

    override fun initView() {


    }
}