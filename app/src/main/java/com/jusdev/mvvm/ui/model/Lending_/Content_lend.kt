package com.jusdev.mvvm.ui.model.Lending_


import com.google.gson.annotations.SerializedName

data class Content_lend(
    @SerializedName("clienteid")
    val clienteid: List<Any>,
    @SerializedName("empresas")
    val empresas: List<Empresa_lend>,
    @SerializedName("lending")
    val lending: List<Lending>,
    @SerializedName("usuarioid")
    val usuarioid: String
)