package com.kotlindemo.ui.fragment

import android.content.Intent
import android.view.View
import com.kotlindemo.R
import com.kotlindemo.base.BaseFragment
import com.kotlindemo.ui.AdviseActivity
import com.kotlindemo.ui.CacheActivity
import com.kotlindemo.ui.WatchActivity
import kotlinx.android.synthetic.main.mine_fragment.*

/**
 * Create By yinwuteng
 * 2018/7/16.
 */
class MineFragment : BaseFragment(), View.OnClickListener {

    override fun getLayoutResources(): Int {
        return R.layout.mine_fragment
    }

    override fun initView() {
        tv_advise.setOnClickListener(this)
        tv_watch.setOnClickListener(this)
        tv_save.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_watch -> {
                var intent = Intent(activity, WatchActivity::class.java)
                startActivity(intent)
            }
            R.id.tv_advise -> {
                var intent = Intent(activity, AdviseActivity::class.java)
                startActivity(intent)
            }
            R.id.tv_save -> {
                var intent = Intent(activity, CacheActivity::class.java)
                startActivity(intent)
            }
        }

    }
}