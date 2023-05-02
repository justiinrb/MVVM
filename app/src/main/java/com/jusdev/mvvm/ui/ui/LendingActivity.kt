package com.jusdev.mvvm.ui.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
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
import org.w3c.dom.Document

class LendingActivity : AppCompatActivity(),Adapter_Operaciones.OnclickListener{


    private lateinit var viewmodel: LendingViewModel
    private lateinit var binding: ActivityLendingBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterRecy
    private var datalis = mutableListOf<Lending>()
    var layautmanayer: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLendingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AdapterRecy(this, datalis,this)
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
                recyclerView.adapter = AdapterRecy(this, listaempresa!!,this)
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
/*
        val button : TextView = findViewById(R.id.titleTv)
        button.setOnClickListener {
            startActivity(Intent(this,Object::class.java).apply {
                putExtra("dataObj","")
            })
        }

    val intent = Intent(applicationContext,Object::class.java)
            val lend = Lending ("idcliente","nombre", arrayListOf(Operacione("BALANCE","DOCUMENTO","FECHA")))
            intent.putExtra("Lending",lend)
            startActivity(intent)

 */

    }

     override fun OnClick(item: Operacione,lending:Lending) {
         println("Clickk " + item.BALANCE)
         val intent = Intent(this,Activity_data::class.java)
         intent.putExtra("Document",item.DOCUMENTO)
         intent.putExtra("Fecha",item.FECHA)
         intent.putExtra("Balance",item.BALANCE)
         intent.putExtra("NameGrup",lending.nombre)

         startActivity(intent)

     }


     private fun other() {
        binding.custbar.ivBack.setOnClickListener {
            val editProfileIntent = Intent(this, Idn::class.java)
            startActivity(editProfileIntent)
        }
    }


 }








