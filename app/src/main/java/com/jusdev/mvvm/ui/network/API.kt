package com.jusdev.mvvm.ui.network

import com.jusdev.mvvm.ui.model.Posts
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface API {
    @GET("posts/1")
    suspend fun getPosts(): Posts


    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost(
        @Field("userId") userId:Int,
        @Field("id") id:Int,
        @Field("title")title:String,
        @Field("body") body :String,


    ):Response<Posts>
}