package com.kotlindemo.mvp.presenter

import android.content.Context
import com.kotlindemo.mvp.contract.FindContract
import com.kotlindemo.mvp.model.FindModel
import com.kotlindemo.mvp.model.bean.FindBean
import com.kotlindemo.utils.applySchedulers
import io.reactivex.Observable

/**
 * Create By yinwuteng
 * 2018/8/6.
 */
class FindPresenter(context: Context, view: FindContract.View) : FindContract.Preenter {
    var mContext: Context? = null
    var mView: FindContract.View? = null
    val mModel: FindModel by lazy { FindModel() }

    init {
        mView = view
        mContext = context
    }


    override fun start() {
        requetData()
    }

    override fun requetData() {
        val observable: Observable<MutableList<FindBean>>? = mContext?.let {
            mModel.loadata(mContext!!)
        }
        observable?.applySchedulers()?.subscribe { beans: MutableList<FindBean> ->
            mView?.setData(beans)
        }
    }
}



