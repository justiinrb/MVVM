package com.jusdev.mvvm.ui.model.Lending_


import com.google.gson.annotations.SerializedName

data class Lending(
    @SerializedName("idcliente")
    val idcliente: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("operaciones")
    val operaciones: List<Operacione>
)