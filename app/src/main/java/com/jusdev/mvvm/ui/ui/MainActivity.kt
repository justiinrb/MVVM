package com.jusdev.mvvm.ui.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.jusdev.mvvm.R

import com.jusdev.mvvm.databinding.ActivityMainBinding
import com.jusdev.mvvm.ui.model.Posts
import com.jusdev.mvvm.ui.model.ResponseLogin
import com.jusdev.mvvm.ui.repository.Repository
import com.jusdev.mvvm.ui.viewmodel.MainViewModel
import com.jusdev.mvvm.ui.viewmodelfactory.MainViewModelFactory
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        // viewModel.getPosts()
        val post = Posts("krocafuerte",
            "desarrollo2020",
            "iOS",
            "1.0.17",
            "22",
            "iPhone",
            "iPhone 8",
            "15.2",
            "cfTKdvTY80Cyu0xei_FzJC:APA91bExC4a9T2dtfhUhm1CwR-H9CmNkzkLPPZF-l842UyyvsA6cJ7Pzj7tCOV21GpYP08TVXqA6qUbXjAYl6ekv0OxTpPHM9KqlPFHUI0H-tYd17sTHnf_SBlTtNy-CoKYKz2EOBZ3I"
        )
        viewModel.pushPosts(post)

        viewModel.mypushResponse.observe(this, Observer { response ->
            //result.text = response.toString()
            val gson = GsonBuilder().setPrettyPrinting().create()
            val prettyJson = gson.toJson(
                JsonParser.parseString(
                    response.body()
                        ?.string() // About this thread blocking annotation : https://github.com/square/retrofit/issues/3255
                )
            )

            Log.d("Pretty Printed JSON :", prettyJson)

            println(response.toString())

            try {
                var gson = Gson()
                var myClass = gson?.fromJson(prettyJson, ResponseLogin::class.java)
                //val _myClass: ResponseLogin = Gson().fromJson(responseBody, ResponseLogin::class.java)

                println("result: " + myClass?.content?.empresas)
            }catch (e :Exception){
                println("result-error: " + e.message)
            }
        })

    }
}