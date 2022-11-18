package com.jusdev.mvvm.ui.repository

import com.jusdev.mvvm.ui.model.Posts
import com.jusdev.mvvm.ui.network.RetrofitInstance
import retrofit2.Response
import com.jusdev.mvvm.ui.network.RetrofitInstance.api

class Repository {
    // Repository Class
    suspend fun getPosts(): Posts {
        return RetrofitInstance.api.getPosts()
    }

    //post field repository code
    suspend fun pushPots(userid : Int, id : Int , title:String, body:String): Response<Posts> {
        return RetrofitInstance.api.pushPost(userid,id,title,body)
    }

}