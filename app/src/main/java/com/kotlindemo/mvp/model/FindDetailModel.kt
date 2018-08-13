package com.kotlindemo.mvp.model

import android.content.Context
import com.kotlindemo.mvp.model.bean.HotBean
import com.kotlindemo.network.ApiService
import com.kotlindemo.network.RetrofitClient
import io.reactivex.Observable

/**
 * Create By yinwuteng
 * 2018/8/13.
 */
class FindDetailModel {
    fun loadData(context: Context, categoryName: String, strategy: String): Observable<HotBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getFindDetailData(categoryName, strategy, "26868b32e808498db32fd51fb422d00175e179df", 83)
    }

    fun loadMoreData(context: Context,start : Int, categoryName: String, strategy: String?): Observable<HotBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getFindDetailMoreData(start,10,categoryName, strategy!!)
    }
}