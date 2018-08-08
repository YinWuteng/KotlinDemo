package com.kotlindemo.mvp.model

import android.content.Context
import com.kotlindemo.mvp.model.bean.HotBean
import com.kotlindemo.network.ApiService
import com.kotlindemo.network.RetrofitClient
import io.reactivex.Observable

/**
 * Create By yinwuteng
 * 2018/8/8.
 */
class HotModel {
    fun loadData(context: Context, strategy: String?): Observable<HotBean>? {
        var retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getHotData(10, strategy!!, "26868b32e808498db32fd51fb422d00175e179df", 83)
    }
}