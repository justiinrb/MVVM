package com.jusdev.mvvm.repository

import com.jusdev.mvvm.services.RetrofitClient
import com.jusdev.mvvm.services.WebService

class PokemonRepository {
    private var apiService: WebService? = null

        //inicializar el proceso
    init {
        // traer el getclient y webservice - url
        apiService = RetrofitClient.getclient?.create(WebService::class.java)
    }
    //suspend fun se ejecutan en segundo plano
    //traer los pokemons
    suspend fun getpokemon()=apiService?.getpokemons()

}