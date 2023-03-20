package com.jusdev.mvvm.ui.network

import com.jusdev.mvvm.ui.model.Posts
import com.jusdev.mvvm.ui.model.ResponseLogin
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface API {
    //Get
    @GET("login/")
    suspend fun getPosts(): Posts

    @FormUrlEncoded
    @POST("login/")
    suspend fun pushPost(
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

    @FormUrlEncoded
    @POST("login/")
    suspend fun getDataLogin(
        @Field("error") error: Boolean,
        @Field("msg") msg: String,
    ): Response<ResponseLogin>
}
/*
 @FormUrlEncoded
    @POST("login/")
     fun pushPost(
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
 */