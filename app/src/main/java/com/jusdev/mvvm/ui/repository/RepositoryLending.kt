package com.jusdev.mvvm.ui.repository

import com.jusdev.mvvm.ui.model.Lending_.PostLending
import com.jusdev.mvvm.ui.network.LendingInstance

import okhttp3.ResponseBody
import retrofit2.Response

class RepositoryLending {
    suspend fun PushPotsLending(postLend: PostLending): Response<ResponseBody> {

        return LendingInstance.apiLend.PushPostLend(
            postLend.usuarioid,
            postLend.empresa,
            postLend.brokerid,
            postLend.roleid,
            postLend.clienteid,
            postLend.corte,
            postLend.website,

            )
    }

}