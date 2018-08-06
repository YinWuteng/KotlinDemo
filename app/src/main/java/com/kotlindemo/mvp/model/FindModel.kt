package com.kotlindemo.mvp.model

import android.content.Context

import com.kotlindemo.mvp.model.bean.FindBean
import com.kotlindemo.network.ApiService
import com.kotlindemo.network.RetrofitClient
import io.reactivex.Observable

/**
 * Create By yinwuteng
 * 2018/7/20.
 */
class FindModel {
    fun loadata(context: Context): Observable<MutableList<FindBean>>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getFindData()
    }
}