package com.jusdev.mvvm.ui.model

class QuoteProvider {


    //Static class
    companion object {
        fun ramdons(): QuoteModel {
            val psosition = (0..10).random()
            return quote[psosition]
        }

        private val quote = listOf<QuoteModel>(
            QuoteModel(quote = "assecc", "Dave"),
            QuoteModel(quote = "diviiss", "leyl"),
            QuoteModel(quote = "seccion s ", "ker"),
            QuoteModel(quote = "operaciones", "antho"),
            QuoteModel(quote = "trig s tr", "dan"),
            QuoteModel(quote = "sutent", "krist"),
            QuoteModel(quote = "lion s help", "livv"),
            QuoteModel(quote = "sutent", "susan"),
        )
    }
}