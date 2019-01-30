package com.kotlindemo.mvp.model

import android.content.Context
import com.kotlindemo.mvp.model.bean.HomeBean
import com.kotlindemo.network.ApiService
import com.kotlindemo.network.RetrofitClient
import io.reactivex.Observable

/**
 * Create By yinwuteng
 * 2018/7/20.
 */
class HomeModel {
    fun loadData(context: Context, isFirst: Boolean, data: String?): Observable<HomeBean>? {
        val  retrofitClient=RetrofitClient.getInstance(context,ApiService.BASE_URL)
        val apiService=retrofitClient.create(ApiService::class.java)
        return when(isFirst){
            true-> apiService?.getHomeData()
            false-> apiService?.getHomeMoreData(data.toString(),"2")
        }
    }
}