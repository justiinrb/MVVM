package com.jusdev.mvvm.ui.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiLogin {
    @FormUrlEncoded
    @POST("login/")
    suspend fun pushPostLogin(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("platform") platform: String,
        @Field("version") version: String,
        @Field("build") build: String,
        @Field("modelDevice") modelDevice: String,
        @Field("nameDevice") nameDevice: String,
        @Field("versionSystem") versionSystem: String,
        @Field("tokendevice") tokendevice: String
    ): Response<ResponseBody>
}