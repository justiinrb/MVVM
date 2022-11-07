package com.jusdev.mvvm.services


import com.jusdev.mvvm.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private var retrofit: Retrofit? = null

    private const val BASE_URL = "https://raw.githubusercontent.com/Biuni/PokemonGo-Pokedex/master/"


    private val logger: OkHttpClient
        //get traer los datos
        get() {
            //interceptor debuguear la app
            //nos trae el objeto y los muestra
            var logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            //builder construir un objeto
            val httpclient = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                httpclient.interceptors().add(logging)
            }
            return httpclient.build()
        }
    val getclient:Retrofit?
    get() {
            if (retrofit == null){
                //builder construir el objeto
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(logger)
                    .build()

            }
        return retrofit
    }
}