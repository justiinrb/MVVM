package com.jusdev.mvvm.ui.ui.documents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jusdev.mvvm.R
import com.jusdev.mvvm.databinding.DocBinding
import com.jusdev.mvvm.ui.ui.documents.adapter.ViewAdapt


class Doc : Fragment(R.layout.doc) {


    private var _binding: DocBinding ? = null

    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // As the binding class will change, binding inflate method will also change from fragment to fragment
        _binding = DocBinding.inflate(inflater, container, false)
        setUptabs()
        return binding.root
    }

    private fun setUptabs() {
        val adapter = getFragmentManager()?.let { ViewAdapt(it) }
        adapter?.addFragment(Dc_imgFragment(),"")
        adapter?.addFragment(Dc_rotateFragment(),"")
        adapter?.addFragment(Dc_receiptFragment(),"")
        binding.viewpa.adapter = adapter
        binding.tab.setupWithViewPager(binding.viewpa)

        binding.tab.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_broken_image_24)
        binding.tab.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_rotate_right_24)
        binding.tab.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_receipt_24)

    }
}

