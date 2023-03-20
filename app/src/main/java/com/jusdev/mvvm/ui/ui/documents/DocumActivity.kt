package com.jusdev.mvvm.ui.ui.documents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jusdev.mvvm.databinding.ActivityDocumBinding

class DocumActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDocumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDocumBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }




}



