package com.jusdev.mvvm.ui.model.Lending_


import com.google.gson.annotations.SerializedName

data class Empresa_lend(
    @SerializedName("id")
    val id: String,
    @SerializedName("nombre")
    val nombre: String
)