package com.jusdev.mvvm.ui.ui.Reports

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jusdev.mvvm.R
import com.jusdev.mvvm.databinding.FragmentStatementBinding
import com.jusdev.mvvm.ui.ui.documents.DocumActivity


class StatementFragment : Fragment() {

    private var _binding: FragmentStatementBinding? = null

    private lateinit var communicator: Communicator

    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // As the binding class will change, binding inflate method will also change from fragment to fragment
        _binding = FragmentStatementBinding.inflate(inflater, container, false)
        web()

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.Bton1.setOnClickListener {

            val editProfileIntent = Intent(getActivity(), DocumActivity::class.java)
            getActivity()?.startActivity(editProfileIntent)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun web() {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.docsity.com/es/dentinogenesis-y-celulas-formadoras-de-dentina/2582320/")
        )
        binding.Bton2.setOnClickListener {
            startActivity(intent)
        }
    }

}