package com.jusdev.mvvm.ui.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface API_Len {

    @FormUrlEncoded
    @POST("lending/")
suspend fun PushPostLend(
        @Field("usuarioid")usuarioid: String,
        @Field("empresas")empresas: String,
        @Field("brokerid")brokerid: String,
        @Field("roleid")roleid: String,
        @Field("clienteid")clienteid: String,
        @Field("corte")corte: String,
        @Field("website")website: String,

    ): Response<ResponseBody>
}