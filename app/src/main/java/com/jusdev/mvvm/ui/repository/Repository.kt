package com.jusdev.mvvm.ui.repository

import com.jusdev.mvvm.ui.model.Posts
import com.jusdev.mvvm.ui.model.ResponseLogin
import com.jusdev.mvvm.ui.network.RetrofitInstance
import retrofit2.Response
import com.jusdev.mvvm.ui.network.RetrofitInstance.api
import okhttp3.ResponseBody

class Repository {
    // Repository Class //GET
    suspend fun getPosts(): Posts {
        return RetrofitInstance.api.getPosts()
    }

    //post field repository code
    suspend fun pushPots(
       post : Posts
    ): Response<ResponseBody> {
        return RetrofitInstance.api.pushPost(
            post.username,
            post.password,
            post.platform,
            post.version,
            post.build,
            post.modelDevice,
            post.nameDevice,
            post.versionSystem,
            post.tokendevice
        )
    }

}