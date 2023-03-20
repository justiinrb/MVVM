package com.jusdev.mvvm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jusdev.mvvm.databinding.ActivityLendingBinding
import com.jusdev.mvvm.ui.ui.Idn

class LendingActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLendingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLendingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        other()

    }

    private fun other() {
     binding.custbar.ivBack.setOnClickListener {
         val editProfileIntent = Intent(this, Idn::class.java)
         startActivity(editProfileIntent)
     }


    }


}
