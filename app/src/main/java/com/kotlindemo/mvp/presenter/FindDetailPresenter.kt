package com.kotlindemo.mvp.presenter

import android.content.Context
import com.kotlindemo.mvp.contract.FindDetailContract
import com.kotlindemo.mvp.model.FindDetailModel
import com.kotlindemo.mvp.model.bean.HotBean
import com.kotlindemo.utils.applySchedulers
import io.reactivex.Observable

/**
 * Create By yinwuteng
 * 2018/8/13.
 */
class FindDetailPresenter(context: Context, view: FindDetailContract.View) : FindDetailContract.Presenter {


    var mContext: Context? = null
    var mView: FindDetailContract.View? = null
    val mModel: FindDetailModel by lazy { FindDetailModel() }

    init {
        mView = view
        mContext = context
    }

    override fun requestData(category: String, strategy: String) {
        val observable: Observable<HotBean>? = mContext?.let { mModel.loadData(mContext!!, category, strategy) }
        observable?.applySchedulers()?.subscribe { bean: HotBean -> mView?.setData(bean) }
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun requestMoreData(start: Int, category: String, strategy: String) {
        val observable: Observable<HotBean>? = mContext.let { mModel.loadMoreData(mContext!!, start, category, strategy) }
        observable?.applySchedulers()?.subscribe { bean: HotBean -> mView?.setData(bean) }
    }
}


