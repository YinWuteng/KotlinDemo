package com.kotlindemo.mvp.contract

import com.kotlindemo.base.BasePresenter
import com.kotlindemo.base.BaseView
import com.kotlindemo.mvp.model.bean.HomeBean

/**
 * Create By yinwuteng
 * 2018/8/6.
 */
class HotContract {

    interface View:BaseView<Presenter>{
        fun setData(bean: HomeBean)
    }
    interface Presenter : BasePresenter {
        fun requesData(strategy: String)
    }
}