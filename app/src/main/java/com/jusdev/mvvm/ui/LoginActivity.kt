package com.jusdev.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import com.jusdev.mvvm.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)




        var click = findViewById<Button>(R.id.logn)

        click.setOnClickListener {
            Toast.makeText(this, "Kotlin", Toast.LENGTH_SHORT).show()
        }

    }


}