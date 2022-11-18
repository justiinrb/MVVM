package com.jusdev.mvvm.ui.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jusdev.mvvm.R

import com.jusdev.mvvm.databinding.ActivityMainBinding
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
        viewModel.pushPosts(1, 1, "Doctor Speed Code", "Android Developer!")

        viewModel.mypushResponse.observe(this, Observer { response ->
            //result.text = response.toString()
            println(response.toString())
        })

    }
}