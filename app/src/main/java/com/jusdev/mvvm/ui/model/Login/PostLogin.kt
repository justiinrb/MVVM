package com.jusdev.mvvm.ui.model.Login

data class PostLogin(
    val username : String,
    val password : String,
    val platform : String,
    val version : String,
    val build : String,
    val modelDevice : String,
    val nameDevice : String,
    val versionSystem : String,
    val tokendevice: String,
)
