package com.jusdev.mvvm.ui.ui.Reports

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jusdev.mvvm.databinding.FragmentStatementBinding
import com.jusdev.mvvm.ui.ui.documents.DocumActivity


class StatementFragment : Fragment() {

    private var _binding: FragmentStatementBinding? = null

    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // As the binding class will change, binding inflate method will also change from fragment to fragment
        _binding = FragmentStatementBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.Bton1.setOnClickListener {

            val editProfileIntent = Intent(getActivity(), DocumActivity::class.java)
            getActivity()?.startActivity(editProfileIntent)
        }
    }

}