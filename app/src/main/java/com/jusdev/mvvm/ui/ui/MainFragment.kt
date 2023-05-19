package com.jusdev.mvvm.ui.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.jusdev.mvvm.R
import com.jusdev.mvvm.databinding.FragmentMainBinding
import com.jusdev.mvvm.databinding.FragmentReportsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.Bton2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment3_to_blankFragment)
        }

    }


}