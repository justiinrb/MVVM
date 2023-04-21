package com.jusdev.mvvm.ui.model.Lending_


import com.google.gson.annotations.SerializedName
import com.jusdev.mvvm.ui.model.Lending_.Content_lend

data class Editjson(
    @SerializedName("content")
    val content: Content_lend,
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("msg")
    val msg: String
)