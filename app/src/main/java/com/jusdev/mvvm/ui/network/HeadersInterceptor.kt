package com.jusdev.mvvm.ui.network

import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader("version","1.0.17")
            .build()
        return chain.proceed(request)
    }
}