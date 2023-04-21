package com.jusdev.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jusdev.mvvm.ui.model.Lending_.PostLending
import com.jusdev.mvvm.ui.repository.RepositoryLending
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response

class LendingViewModel (private val repositoryLend: RepositoryLending): ViewModel() {

    var pushrespLend: MutableLiveData<Response<ResponseBody>> = MutableLiveData()

    fun shoveLend(postLend: PostLending){

        viewModelScope.launch {
            val response = repositoryLend.PushPotsLending(postLend)
            pushrespLend.value = response
        }


    }
}