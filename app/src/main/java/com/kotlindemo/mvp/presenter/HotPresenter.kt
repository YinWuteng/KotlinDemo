package com.kotlindemo.mvp.presenter

import android.content.Context
import com.kotlindemo.mvp.contract.HotContract
import com.kotlindemo.mvp.model.HotModel
import com.kotlindemo.mvp.model.bean.HotBean
import com.kotlindemo.utils.applySchedulers
import io.reactivex.Observable

/**
 * Create By yinwuteng
 * 2018/8/8.
 */
class HotPresenter(context: Context, view: HotContract.View) : HotContract.Presenter {
    var mContext: Context? = null
    var mView: HotContract.View? = null
    val mModel: HotModel by lazy { HotModel() }

    init {
        mView = view
        mContext = context
    }

    override fun requesData(strategy: String) {
        var observable: Observable<HotBean>? = mContext?.let {
            mModel.loadData(mContext!!, strategy)
        }
        observable?.applySchedulers()?.subscribe { bean: HotBean ->
            mView?.setData(bean)
        }
    }

    override fun start() {
    }
}