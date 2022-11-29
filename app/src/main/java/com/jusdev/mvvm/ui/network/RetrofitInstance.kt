package com.jusdev.mvvm.ui.network

import com.jusdev.mvvm.ui.const.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // retrofit instance object class
    private val retrofit by lazy {
        Retrofit.Builder()
            .client(getClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .addInterceptor(HeadersInterceptor())
            .build()
        return client
    }

    val api: API by lazy {
        retrofit.create(API::class.java)
    }
}