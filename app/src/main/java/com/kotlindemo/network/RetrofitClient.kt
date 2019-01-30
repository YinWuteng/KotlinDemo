package com.kotlindemo.network

import android.content.Context
import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Create By yinwuteng
 * 2018/7/20.
 */
class RetrofitClient private constructor(context: Context, baseUrl: String) {
    private var httpCacheDirectory: File? = null
    private val mContext: Context = context
    private var cache: Cache? = null
    private var okhttpClient: OkHttpClient? = null
    private var retrofit: Retrofit? = null
    private val DEFAULT_TIMEOUT: Long = 20
    val url = baseUrl

    init {
        //缓存地址
        if (httpCacheDirectory == null) {
            httpCacheDirectory = File(mContext.cacheDir, "app_cache")
        }
        try {
            if (cache == null) {
                cache = Cache(httpCacheDirectory, 10 * 1024 * 1024)
            }
        } catch (e: Exception) {
            Log.e("OKHttp", "Could not create http cache", e)
        }

        //创建okhttp
        okhttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .cache(cache)
                .addNetworkInterceptor(CacheInterceptor(context))
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build()
        //retrofit创建了
        retrofit = Retrofit.Builder()
                .client(okhttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build()

    }

    companion object {
        @Volatile
        var instances: RetrofitClient? = null

        fun getInstance(context: Context, baseUrl: String): RetrofitClient {
            if (instances == null) {
                synchronized(RetrofitClient::class) {
                    if (instances == null) {
                        instances = RetrofitClient(context, baseUrl)
                    }
                }
            }
            return instances!!
        }
    }

    fun <T> create(service: Class<T>?): T? {
        if (service == null) {
            throw RuntimeException("Api service is null!")
        }
        return retrofit?.create(service)
    }
}