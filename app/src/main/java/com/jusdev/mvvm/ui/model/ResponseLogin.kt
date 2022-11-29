package com.jusdev.mvvm.ui.model

import com.google.gson.annotations.SerializedName

data class ResponseLogin (

   var content: Content,
 val error : Boolean,
  val msg : String

    )