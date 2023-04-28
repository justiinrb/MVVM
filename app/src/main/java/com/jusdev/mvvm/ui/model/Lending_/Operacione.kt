package com.jusdev.mvvm.ui.model.Lending_


import com.google.gson.annotations.SerializedName

data class Operacione(
    @SerializedName("BALANCE")
    val BALANCE: String,
    @SerializedName("DOCUMENTO")
    val DOCUMENTO: String,
    @SerializedName("FECHA")
    val FECHA: String,


)