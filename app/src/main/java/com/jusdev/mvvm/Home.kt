package com.jusdev.mvvm

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jusdev.mvvm.databinding.DocBinding
import com.jusdev.mvvm.databinding.FragmentHomeBinding
import com.jusdev.mvvm.ui.ui.documents.DocumActivity


class Home : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // As the binding class will change, binding inflate method will also change from fragment to fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        lend()
        return binding.root
    }

    private fun lend() {
        binding.lend.setOnClickListener {
            val editProfileIntent = Intent(getActivity(), LendingActivity::class.java)
            getActivity()?.startActivity(editProfileIntent)
        }

    }


}


