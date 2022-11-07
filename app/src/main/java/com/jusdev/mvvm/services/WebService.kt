package com.jusdev.mvvm.services

import retrofit2.Response
import com.jusdev.mvvm.model.PokemonResponse
import retrofit2.http.GET

interface WebService {

    @GET("pokedex.json")
    //ver que se importe de retrofit
       suspend fun getpokemons(): Response<PokemonResponse>



}