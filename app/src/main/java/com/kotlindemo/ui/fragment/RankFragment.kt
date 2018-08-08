package com.kotlindemo.ui.fragment

import com.kotlindemo.base.BaseFragment
import com.kotlindemo.mvp.contract.HotContract
import com.kotlindemo.mvp.model.bean.HotBean
import com.kotlindemo.mvp.presenter.HotPresenter

/**
 * Create By yinwuteng
 * 2018/8/6.
 */
class RankFragment : BaseFragment(), HotContract.View {

    lateinit var mPresenter: HotPresenter
    lateinit var mStrategy: String

    override fun getLayoutResources(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setData(bean: HotBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}