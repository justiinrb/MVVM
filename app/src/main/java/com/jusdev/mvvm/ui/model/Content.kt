package com.jusdev.mvvm.ui.model

import com.google.gson.annotations.SerializedName

data class Content(

    val usuarioid: String,
    val correo: String,
    val id_role: String,
    val cantd_clients: String,
    val id_broker: String,
    val nombre: String,
    val version: String,
    val build: String,
    val platform: String,
    val clientid: ArrayList<Clientid>,
    val empresas: ArrayList<Empresas>
)

