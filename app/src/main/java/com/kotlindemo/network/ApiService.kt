package com.kotlindemo.network

import com.kotlindemo.mvp.model.bean.FindBean
import com.kotlindemo.mvp.model.bean.HomeBean
import com.kotlindemo.mvp.model.bean.HotBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Create By yinwuteng
 * 2018/7/20.
 */
interface ApiService {
    companion object {
        var BASE_URL: String = ""
            get() = "http://baobab.kaiyanapp.com/api/"
    }

    /**
     * 获取首页第一页数据
     */
    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getHomeData(): Observable<HomeBean>

    /**
     * 获取首页后的更多数据
     */
    @GET("v2/feed")
    fun getHomeMoreData(@Query("date") date: String, @Query("num") num: String): Observable<HomeBean>

    /**
     * 获取发现频道信息
     */
    @GET("v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getFindData(): Observable<MutableList<FindBean>>

    //获取热门排行信息
    @GET("v3/ranklist")
    fun getHotData(@Query("num") num: Int, @Query("strategy") strategy: String,
                   @Query("udid") udid: String, @Query("vc") vc: Int
    ): Observable<HotBean>

    //获取发现频道详情信息
    @GET("v3/videos")
    fun getFindDetailData(@Query("categoryName") categoryName: String, @Query("strategy") strategy: String,
                          @Query("udid") udid: String, @Query("vc") vc: Int
    ): Observable<HotBean>

    //获取发现详情加载更多消息
    @GET("v3/videos")
    fun getFindDetailMoreData(@Query("start") start :Int,@Query("num") num :Int,
                              @Query("categoryName") categoryName :String,@Query("strategy") strategy :String) : Observable<HotBean>

}