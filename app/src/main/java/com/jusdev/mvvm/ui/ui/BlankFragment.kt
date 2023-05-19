package com.jusdev.mvvm.ui.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jusdev.mvvm.R
import com.jusdev.mvvm.databinding.FragmentBackupBinding
import com.jusdev.mvvm.databinding.FragmentBlankBinding
import com.jusdev.mvvm.databinding.FragmentHomeBinding


class BlankFragment : Fragment() {

private var _binding : FragmentBlankBinding?=null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}