package com.jusdev.mvvm.model

import com.bumptech.glide.request.BaseRequestOptions
import com.jusdev.mvvm.databinding.PokemonRowBinding

data class PokemonResponse(

    val pokemon: MutableList<PokemonDataModel> = mutableListOf()

)

data class PokemonDataModel(

    val id: Long,
    val name: String = "",
    val img: String
) {

}

