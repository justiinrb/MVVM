package com.jusdev.mvvm


import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jusdev.mvvm.databinding.FragmentLend1Binding
import com.jusdev.mvvm.databinding.FragmentPersonBinding
import com.jusdev.mvvm.ui.ui.LoginActivity


class Person : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit  var toggle : ActionBarDrawerToggle
    private lateinit var builder: AlertDialog.Builder
    private var _binding: FragmentPersonBinding? = null


    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding =  FragmentPersonBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        firebaseAuth = Firebase.auth
        builder = AlertDialog.Builder(requireContext() )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.new_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.buscar ->{
                Toast.makeText(requireContext(),"Buscar inf",Toast.LENGTH_SHORT).show()
            }
            R.id.menu_salir->
            {
                builder.setMessage("Cerrar la sesion de tu cuenta?")
                    .setCancelable(true)
                    .setPositiveButton("yes"){dialogInterface,it->
                        singOut()
                    }
                    .setNegativeButton("No"){dialogInterface ,it->

                        dialogInterface.cancel()
                    }
                    .show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun singOut(){
        firebaseAuth.signOut()
        val i = Intent(getActivity(),LoginActivity::class.java)
        getActivity()?.startActivity(i)
    }



}