package com.jusdev.mvvm.ui.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.jusdev.mvvm.*
import com.jusdev.mvvm.databinding.ActivityIdnBinding
import com.jusdev.mvvm.ui.Utils.AppPermissions
import com.jusdev.mvvm.ui.ui.BackUp.Backup
import com.jusdev.mvvm.ui.ui.Reports.Reports
import com.jusdev.mvvm.ui.ui.documents.Doc

class Idn : AppCompatActivity() {

    private lateinit var binding: ActivityIdnBinding
    private lateinit var permission :AppPermissions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdnBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Rplace()
        replaceFragment(Home())

        permission = AppPermissions()

        if (permission.isLocation(this)){
            println("Allowed")

        }else{
            permission.RequestPemision(this)
            println("denied")
        }

    }
    private fun Rplace(){
        binding.bottomNavigationView.setOnItemSelectedListener {
            println("bottmmm" + it.itemId)

            when (it.itemId) {
                R.id.home -> replaceFragment(Home())
                R.id.documents -> replaceFragment(Doc())
                R.id.reports -> replaceFragment(Reports())
                R.id.up -> replaceFragment(Backup())
                R.id.person -> replaceFragment(Person())

                else -> throw IllegalArgumentException("se vuelve a cargar")
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()


    }
}