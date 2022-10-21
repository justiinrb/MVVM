package com.jusdev.mvvm.data

import com.jusdev.mvvm.ui.modelo.Frutas

class FrutasDataSet {
    fun crearlistafeutas(): List<Frutas> {

        return listOf(
            Frutas("Banana", "Amarillo", 5.0f, 20.0f),
            Frutas("Naranja", "Naranja", 10f, 15.0f),
            Frutas("Sandia", "Verde", 2.50f, 30.02f),
            Frutas("Manzana", "Rojo", 25f, 32f)
        )
    }
}