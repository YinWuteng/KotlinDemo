package com.kotlindemo.adapter


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Create By yinwuteng
 * 2018/8/9.
 */
class HotAdapter(fm: FragmentManager, list: ArrayList<Fragment>, title: MutableList<String>) : FragmentPagerAdapter(fm) {
    var mFm: FragmentManager = fm!!
    var mList: ArrayList<Fragment> = list
    var mTitles: MutableList<String> = title
    override fun getItem(position: Int): Fragment {
        return mList[position]
    }

    override fun getCount(): Int {
        return mList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles[position]
    }
}