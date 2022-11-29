package com.jusdev.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.jusdev.mvvm.ui.model.Posts
import com.jusdev.mvvm.ui.model.ResponseLogin
import com.jusdev.mvvm.ui.repository.Repository
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Posts> = MutableLiveData()//GET
    var mypushResponse: MutableLiveData<Response<ResponseBody>> = MutableLiveData()

    //GET
    fun getPosts() {
        viewModelScope.launch {
            val response = repository.getPosts()
            myResponse.value = response
        }
    }

    fun pushPosts(
        post: Posts
    ) {
        viewModelScope.launch {
            val response = repository.pushPots(
                post
            )


            mypushResponse.value = response
        }
    }
}