package com.jusdev.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

import com.jusdev.mvvm.R
import com.jusdev.mvvm.databinding.ActivityMainBinding
import com.jusdev.mvvm.ui.viewmodel.QuoteViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quoteViewModel.quoteModel.observe(this, Observer {curren->
        binding.tvQuote.text=curren.quote
        binding.tvAuthor.text=curren.author

        })
        binding.viewContainer.setOnClickListener {  quoteViewModel.ramdonQuote() }
    }
}