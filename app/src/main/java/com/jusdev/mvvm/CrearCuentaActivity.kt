package com.jusdev.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jusdev.mvvm.databinding.ActivityCrearCuentaBinding


class CrearCuentaActivity : AppCompatActivity() {


    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityCrearCuentaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        BtonNewAccount()
        firebaseAuth = Firebase.auth

    }
    private fun BtonNewAccount(){

        binding.btnAccount.setOnClickListener {
            var pass1 = binding.Pass1.text.toString()
            var pass2 = binding.Pass2.text.toString()
            if (pass1.equals(pass2)){

                NewAccount(binding.NewEmail.text.toString(),binding.Pass1.text.toString())
            }else{
                Toast.makeText(baseContext,"Error password no coinciden",Toast.LENGTH_SHORT).show()
                binding.Pass1.requestFocus()
            }

        }
    }
    private fun NewAccount(email:String,pass:String){

        firebaseAuth.createUserWithEmailAndPassword(email,pass)
            .addOnCompleteListener(this){task->
                if(task.isSuccessful){
                    Toast.makeText(baseContext," You Account has been create",Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(baseContext," Not has been create Account Error"+task.exception,Toast.LENGTH_SHORT).show()
                }

            }
    }
}