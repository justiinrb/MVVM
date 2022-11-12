package com.jusdev.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jusdev.mvvm.ui.model.QuoteModel
import com.jusdev.mvvm.ui.model.QuoteProvider

class QuoteViewModel :ViewModel(){

    val quoteModel = MutableLiveData<QuoteModel>()

    fun ramdonQuote(){

    val currenQuote = QuoteProvider.ramdons()

        //postValue cambia el valor
        quoteModel.postValue(currenQuote)
    }

}