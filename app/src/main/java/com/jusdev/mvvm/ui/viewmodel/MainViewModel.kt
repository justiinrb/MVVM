package com.jusdev.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jusdev.mvvm.ui.model.Posts
import com.jusdev.mvvm.ui.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Posts> = MutableLiveData()
    val mypushResponse: MutableLiveData<Response<Posts>> = MutableLiveData()


    fun getPosts() {
        viewModelScope.launch {
            val response = repository.getPosts()
            myResponse.value = response
        }
    }
    fun pushPosts(userid : Int, id : Int , title:String, body:String) {
        viewModelScope.launch {
            val response = repository.pushPots(userid, id, title, body)
            println("result: "+ response.body())
            mypushResponse.value = response
        }
    }
}