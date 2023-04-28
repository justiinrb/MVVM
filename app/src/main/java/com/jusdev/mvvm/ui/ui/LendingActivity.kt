package com.jusdev.mvvm.ui.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.jusdev.mvvm.R
import com.jusdev.mvvm.databinding.ActivityLendingBinding
import com.jusdev.mvvm.ui.model.Lending_.*
import com.jusdev.mvvm.ui.repository.RepositoryLending
import com.jusdev.mvvm.ui.viewmodel.LendingViewModel
import com.jusdev.mvvm.ui.viewmodelfactory.LendingVIewModelFactory

 class LendingActivity : AppCompatActivity() {
    private lateinit var viewmodel: LendingViewModel
    private lateinit var binding: ActivityLendingBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var recc: RecyclerView
    private lateinit var adapter: AdapterRecy
    private var datalis = mutableListOf<Lending>()
    var layautmanayer: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLendingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AdapterRecy(this, datalis)
        recyclerView = findViewById(R.id.recy)
        recyclerView.adapter = adapter
        layautmanayer = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layautmanayer

        other()

        val repository = RepositoryLending()
        val viewModelFactory = LendingVIewModelFactory(repository)
        viewmodel = ViewModelProvider(this, viewModelFactory).get(LendingViewModel::class.java)
        // viewModel.getPosts()
        val post = PostLending(
            "1",
            "1",
            "",
            "",
            "",
            "2022-10-09",
            "1",

            )
        viewmodel.shoveLend(post)
        viewmodel.pushrespLend.observe(this, Observer { response ->
            //result.text = response.toString()
            @SuppressLint("notifyDataSetChanged")
            val gson = GsonBuilder().setPrettyPrinting().create()
            val prettyJson = gson.toJson(
                JsonParser.parseString(
                    response.body()
                        ?.string(), // About this thread blocking annotation : https://github.com/square/retrofit/issues/3255
                )
            )
            //  Log.d("Pretty Printed JSON :", prettyJson)
            println(response.toString() + "println")
            try {
                val gson = Gson()
                val myClass = gson.fromJson(prettyJson, Editjson::class.java)
                //val _myClass: ResponseLogin = Gson().fromJson(responseBody, ResponseLogin::class.java)

                var listaempresa = myClass?.content?.lending
                recyclerView.adapter = AdapterRecy(this, listaempresa!!)
                // println("result: " + myClass?.content?.empresas)

                if (response.isSuccessful) {
                    val list: List<Lending> = listaempresa
                    datalis.clear()
                    datalis.addAll(list)
                    adapter.notifyDataSetChanged()
                }
            } catch (e: Exception) {
                println("re-error: " + e.message)
            }
        })
    }

    private fun other() {
        binding.custbar.ivBack.setOnClickListener {
            val editProfileIntent = Intent(this, Idn::class.java)
            startActivity(editProfileIntent)
        }
    }


 }






