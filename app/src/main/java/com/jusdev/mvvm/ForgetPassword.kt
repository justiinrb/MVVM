package com.jusdev.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jusdev.mvvm.R
import com.jusdev.mvvm.databinding.ActivityForgetPasswordBinding

class ForgetPassword : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding : ActivityForgetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bton()
        firebaseAuth = Firebase.auth
    }

    private fun bton(){
        binding.ResetPass.setOnClickListener {
            ResetPassword(binding.textemail.text.toString())
        }

    }

    private fun ResetPassword(email:String){

        firebaseAuth.sendPasswordResetEmail(email)
            .addOnCompleteListener(){task->
                if(task.isSuccessful){
                    Toast.makeText(baseContext,"Se ha enviado un Correo al "+email,Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(baseContext," Error at the Reseting Password"+task.exception,Toast.LENGTH_SHORT).show()
                }

        }
    }
}