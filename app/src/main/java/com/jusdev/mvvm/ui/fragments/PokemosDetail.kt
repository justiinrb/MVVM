package com.jusdev.mvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.jusdev.mvvm.databinding.FragmentPokemosDetailBinding
import com.jusdev.mvvm.viewmodel.RecyclerPokViewModel

class PokemosDetail : Fragment() {
    private var _binding: FragmentPokemosDetailBinding? = null
    private val binding get() = _binding

    //instancia RecyViewModel
    lateinit var viewModel: RecyclerPokViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            activity?.let {
                ViewModelProvider(it).get(RecyclerPokViewModel::class.java)
            }!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemosDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.itemDataSelectet?.let { data ->
            //this -> Activity-- requieredContext ->> Fragments
        Glide.with(requireContext()).load(data.img).into(binding!!.img)
            binding!!.tvName.text = data.name

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null

    }
    //Static -traer

    companion object{

        fun newInstance()=PokemosDetail()

    }


}