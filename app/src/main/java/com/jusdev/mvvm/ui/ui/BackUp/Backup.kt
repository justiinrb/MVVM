package com.jusdev.mvvm.ui.ui.BackUp

import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.bumptech.glide.manager.SupportRequestManagerFragment

import com.jusdev.mvvm.databinding.FragmentBackupBinding

class Backup : Fragment() {

    private var _binding: FragmentBackupBinding? = null
    val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBackupBinding.inflate(inflater, container, false)


        return binding.root

    }

    private fun Bton(){
        binding.of.setOnClickListener {

        }
    }



   }
