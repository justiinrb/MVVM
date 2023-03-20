package com.jusdev.mvvm.ui.repository

import com.jusdev.mvvm.ui.model.PostLogin
import com.jusdev.mvvm.ui.model.Posts
import com.jusdev.mvvm.ui.network.LoginInstance
import com.jusdev.mvvm.ui.network.RetrofitInstance
import okhttp3.ResponseBody
import retrofit2.Response

class RepositoryLogin {

    suspend fun pshPotsLogin(
        postLog : PostLogin
    ): Response<ResponseBody> {
        return LoginInstance.apiLog.pushPostLogin(
            postLog.username,
            postLog.password,
            postLog.platform,
            postLog.version,
            postLog.build,
            postLog.modelDevice,
            postLog.nameDevice,
            postLog.versionSystem,
            postLog.tokendevice
        )
    }
}