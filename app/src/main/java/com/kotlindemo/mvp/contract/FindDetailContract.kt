package com.kotlindemo.mvp.contract

import com.kotlindemo.base.BasePresenter
import com.kotlindemo.base.BaseView
import com.kotlindemo.mvp.model.bean.HotBean

/**
 * Create By yinwuteng
 * 2018/8/13.
 */
interface FindDetailContract {
    interface View : BaseView<Presenter> {
        fun setData(bean: HotBean)
    }

    interface Presenter : BasePresenter {
        fun requestData(category: String, strategy: String)
    }
}