package com.jusdev.mvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jusdev.mvvm.R
import com.jusdev.mvvm.databinding.FragmentPokemosDetailBinding
import com.jusdev.mvvm.databinding.FragmentPokemosListBinding
import com.jusdev.mvvm.model.PokemonDataModel
import com.jusdev.mvvm.ui.adapter.ItemsAdapter
import com.jusdev.mvvm.viewmodel.RecyclerPokViewModel

class PokemosList : Fragment(), ClickListener {
    lateinit var viewModel: RecyclerPokViewModel
    lateinit var binding: FragmentPokemosListBinding
    private var mAdapter: ItemsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //creamos el viemodel y instanciamos el viewmodel
        viewModel =
            activity?.let {
                ViewModelProvider(it).get(RecyclerPokViewModel::class.java)
            }!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_pokemos_list, container, false)
        binding.viewModel = viewModel
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //inicializacion de recyclerView
        mAdapter = ItemsAdapter(this)
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = mAdapter

        //observador de la lista

        viewModel.listate.observe(viewLifecycleOwner) {

            mAdapter?.setItems(list = it)
            binding.progress.isInvisible = true
        }

        viewModel.progressState.observe(viewLifecycleOwner) { show ->
            binding.progress.isInvisible = show
        }
        viewModel.fetchPokemoData()


    }

    override fun itemSelect(data: PokemonDataModel) {
        viewModel.setItemSelection(data)
        //manejar las transacciones                          //abrir el detalle cuando de el click
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(android.R.id.content, PokemosDetail.newInstance())
            ?.addToBackStack(null)
            ?.commit()
    }
}


interface ClickListener{
    fun itemSelect(data: PokemonDataModel)
}