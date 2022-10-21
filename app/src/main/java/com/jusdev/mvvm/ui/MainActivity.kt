package com.jusdev.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.jusdev.mvvm.R
import com.jusdev.mvvm.ui.modelo.Frutas
import com.jusdev.mvvm.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel : MyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProviders.of(this).get(MyViewModel::class.java)


        val frutasobserver = Observer<List<Frutas>>{

            println("Fruts"+it.toString())

        }

        viewmodel.getlistafrutaslivedata().observe(this,frutasobserver)
    }
}