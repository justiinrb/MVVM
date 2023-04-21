package com.jusdev.mvvm.ui.network

import com.jusdev.mvvm.ui.const.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object LendingInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(getClientes())
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getClientes(): OkHttpClient {
        val cliente = OkHttpClient.Builder()
            .addInterceptor(HeadersInterceptor())
            .build()
        return cliente
    }

    val apiLend: API_Len by lazy {
        retrofit.create(API_Len::class.java)
    }
}