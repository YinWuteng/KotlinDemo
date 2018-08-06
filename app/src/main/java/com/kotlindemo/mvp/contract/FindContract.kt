package com.kotlindemo.mvp.contract

import com.kotlindemo.base.BasePresenter
import com.kotlindemo.base.BaseView
import com.kotlindemo.mvp.model.bean.FindBean

/**
 * Create By yinwuteng
 * 2018/8/6.
 */
interface FindContract {

    interface View:BaseView<Preenter>{
        fun setData(bean:MutableList<FindBean>)
    }
    interface Preenter :BasePresenter{
        fun requetData()
    }
}