package com.jusdev.mvvm.ui.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.jusdev.mvvm.CrearCuentaActivity
import com.jusdev.mvvm.ForgetPassword
import com.jusdev.mvvm.R
import com.jusdev.mvvm.ui.model.Login.PostLogin
import com.jusdev.mvvm.ui.model.Login.ResponseLogin
import com.jusdev.mvvm.ui.repository.RepositoryLogin
import com.jusdev.mvvm.ui.viewmodel.LoginViewModel
import com.jusdev.mvvm.ui.viewmodelfactory.LoginViewModelFactory


class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    private var progressBar: ProgressBar? = null
    private var i = 0
    private var txtView: TextView? = null
    private val handler = android.os.Handler()
    private lateinit var VModel: LoginViewModel
    lateinit var _youremail: EditText
    lateinit var _yourpassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        _youremail = findViewById(R.id.youremail)
        _yourpassword = findViewById(R.id.yourpassword)
        val newAccount : TextView = findViewById(R.id.newAccount)
        val button = findViewById<Button>(R.id.logn)
        val forget = findViewById<Button>(R.id.forgt)
        VModel = LoginViewModel(RepositoryLogin())
        progressBar = findViewById<ProgressBar>(R.id.progress) as ProgressBar
        firebaseAuth = Firebase.auth

/*
        val sharepreference = getSharedPreferences("MY_PRE", Context.MODE_PRIVATE)
        val getusername = sharepreference.getString("USERNAME", "")
        val getpasword = sharepreference.getString("PASSWORD", "")

        if (getusername != null && getpasword != null) {
            val intent = Intent(this, Idn::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        } else {

        }
*/
        newAccount.setOnClickListener {
            val i = Intent(this,CrearCuentaActivity::class.java)
            startActivity(i)
        }
        forget.setOnClickListener {
            val pass = Intent(this, ForgetPassword::class.java)
            startActivity(pass)
        }

        button.setOnClickListener {


            println("validacion" + validate())
            if (validate()) {
                progressBar!!.visibility = View.VISIBLE
                singIn(_youremail.text.toString(),_yourpassword.text.toString())
                val repositoryLogin = RepositoryLogin()
                val viewLoginFactory = LoginViewModelFactory(repositoryLogin)
                VModel = ViewModelProvider(this, viewLoginFactory).get(LoginViewModel::class.java)
                // viewModel.getPosts()
                val postLogin = PostLogin(
                    _youremail.text.toString(),
                    _yourpassword.text.toString(),
                    "iOS",
                    "1.0.17",
                    "22",
                    "iPhone",
                    "iPhone 8",
                    "15.2",
                    "cfTKdvTY80Cyu0xei_FzJC:APA91bExC4a9T2dtfhUhm1CwR-H9CmNkzkLPPZF-l842UyyvsA6cJ7Pzj7tCOV21GpYP08TVXqA6qUbXjAYl6ekv0OxTpPHM9KqlPFHUI0H-tYd17sTHnf_SBlTtNy-CoKYKz2EOBZ3I"

                )

                VModel.shoveLogin(postLogin)
                VModel.pushrespLogin.observe(this, Observer { response ->
                    //result.text = response.toString()
                    progressBar!!.visibility = View.GONE



                    try {
                        val gsoon = GsonBuilder().setPrettyPrinting().create()
                        val prettyJson = gsoon.toJson(
                            JsonParser.parseString(
                                response.body()
                                    ?.string() // About this thread blocking annotation : https://github.com/square/retrofit/issues/3255
                            )

                        )

                        Log.d("Pretty Printed JSON :", prettyJson)
                        var gson = Gson()
                        var myClass = gson?.fromJson(prettyJson, ResponseLogin::class.java)
                        //val _myClass: ResponseLogin = Gson().fromJson(responseBody, ResponseLogin::class.java)

                        println("ERROR " + myClass?.error)
                        if (myClass?.error == true) {
                            println("hay un error" + myClass?.error)
                        } else {
                            val intent = Intent(this, Idn::class.java)
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(intent)
                            finish()


                            println("Succeful")
                        }
                        println("result: " + myClass?.error)
                    } catch (e: Exception) {
                        println("result-error: " + e.message)
                    }
                  /*
                    val username = _youremail.text.toString()
                    val pasword = _yourpassword.text.toString()


                    val editor = sharepreference.edit()
                    editor.putString("USERNAME", username)
                    editor.putString("PASSWORD", pasword)
                    editor.apply()
                */
                })
            }
        }

    }


    private fun validate(): Boolean {
        if (_youremail.text.toString().isEmpty()) {
            Toast.makeText(this, "ingrese el usuario", Toast.LENGTH_SHORT).show()
            return false
        }
        if (_yourpassword.text.toString().isEmpty()) {
            Toast.makeText(this, "ingress la contraseña", Toast.LENGTH_SHORT).show()
            return false
        }
        return true

    }

    private fun singIn(email:String,password :String) {
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){task->
                if (task.isSuccessful){
                    val user =firebaseAuth.currentUser
                    Toast.makeText(baseContext,user?.uid.toString(),Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Idn::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                    finish()

                }else{
                    Toast.makeText(baseContext,"Error de Email y/o password ",Toast.LENGTH_SHORT).show()

                }


        }
    }

}


