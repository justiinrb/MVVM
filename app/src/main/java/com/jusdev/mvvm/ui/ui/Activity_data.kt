package com.jusdev.mvvm.ui.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.jusdev.mvvm.R
import com.jusdev.mvvm.databinding.ActivityDataBinding


class Activity_data : AppCompatActivity() {


    private lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.DocData1.text = intent.getStringExtra("Document")
        binding.fechaData1.text = intent.getStringExtra("Fecha")
        binding.balanceData1.text = intent.getStringExtra("Balance")
        binding.nameGrup.text = intent.getStringExtra("NameGrup")


    }


}