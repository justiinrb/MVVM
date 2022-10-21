package com.jusdev.mvvm.domain

import com.jusdev.mvvm.data.FrutasDataSet
import com.jusdev.mvvm.ui.modelo.Frutas

class FrutasUseCase {
    //instancia
    val frutadataset = FrutasDataSet()
    fun obtenerlistafrutas(): List<Frutas> {
        return frutadataset.crearlistafeutas()

    }
}