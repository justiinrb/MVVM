package com.jusdev.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.jusdev.mvvm.model.PokemonDataModel
import com.jusdev.mvvm.repository.PokemonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RecyclerPokViewModel(app: Application) : AndroidViewModel(app), CoroutineScope {

    private val _itemSelected = MutableLiveData<PokemonDataModel>()
    var itemDataSelectet: PokemonDataModel? = null

    //lisState trae el listado de pokemones MutableLivedata se modifica, Livedata no se modifica
    private val _lisState = MutableLiveData<MutableList<PokemonDataModel>>()
    var listate: LiveData<MutableList<PokemonDataModel>> = _lisState

    // true muestreme el progressBar, false no muestra el progressbar
    private val _progressState = MutableLiveData<Boolean>()
    var progressState: LiveData<Boolean> = _progressState

    private val repository = PokemonRepository()

    //observer - LiveData
    lateinit var observerOncategorySelectet: Observer<PokemonDataModel>

    //menejar asincronia dentro de kotlin
    private val viewModelJob = Job()

    override val coroutineContext: CoroutineContext
        //Dispatchers hilos con las coroutines
        //default operaciones de servicios
        get() = viewModelJob + Dispatchers.Default

    //consumir un servicio
    init {
        initObserver()
    }

    private fun initObserver() {
        observerOncategorySelectet = Observer { value ->
            value.let {
                _itemSelected.value = it
                println("observer" + _itemSelected)
            }
        }
    }

    //evita que se filtre memoria innecesaria
    fun clearSelection() {
        _itemSelected.value = null
    }

    fun setItemSelection(item: PokemonDataModel) {
        itemDataSelectet = item
        println("itemdataselectet" + itemDataSelectet)
    }

    fun fetchPokemoData() {
        _progressState.value = true
        //.launch lanzar una coroutina
        viewModelScope.launch {
            val response = repository.getpokemon()
            response?.body()?.pokemon.let {list->
                _lisState.value = list
                println("respuesta " + response)

                println("lista" + _lisState)
            }
        }
    }
    //oncleared limpiar para que no haya memoria y cancele la corutina momoria leak

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}