package com.kotlindemo.mvp.presenter

import android.content.Context
import com.kotlindemo.mvp.contract.HomeContract
import com.kotlindemo.mvp.model.HomeModel
import com.kotlindemo.mvp.model.bean.HomeBean
import com.kotlindemo.utils.applySchedulers
import io.reactivex.Observable

/**
 * Create By yinwuteng
 * 2018/7/20.
 */
class HomePresenter(context: Context, view: HomeContract.View) : HomeContract.Presenter {
    var mContext: Context? = null
    var mView: HomeContract.View? = null
    val mModel: HomeModel by lazy { HomeModel() }

    init {
        mView = view
        mContext = context
    }

    override fun start() {
        requestData()
    }

    /**
     * 请求数据
     */
    override fun requestData() {
        val observable: Observable<HomeBean>? = mContext?.let { mModel.loadData(it,true,"0")}
        observable?.applySchedulers()?.subscribe { homeBean:HomeBean ->
            mView?.setData(homeBean)
        }
    }

    /**
     * 请求更多数据
     */
    fun moreData(data:String?){
        val observable:Observable<HomeBean>?=mContext?.let { mModel.loadData(it,false,data) }
        observable?.applySchedulers()?.subscribe { homeBean:HomeBean->
            mView?.setData(homeBean)
        }
    }
}