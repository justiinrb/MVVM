package com.jusdev.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jusdev.mvvm.domain.FrutasUseCase
import com.jusdev.mvvm.ui.modelo.Frutas

class MyViewModel : ViewModel() {
    //instancia
    val frutasusecase = FrutasUseCase()
    private val lisdata = MutableLiveData<List<Frutas>>()

    init {
        getlistafrutas()
    }

    fun setlistdata(listafrutas: List<Frutas>) {

        lisdata.value = listafrutas

    }

    fun getlistafrutas() {
        setlistdata(frutasusecase.obtenerlistafrutas())
    }

    fun getlistafrutaslivedata(): LiveData<List<Frutas>> {

        return lisdata
    }

}