package com.jusdev.mvvm.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jusdev.mvvm.R
import com.jusdev.mvvm.databinding.PokemonRowBinding
import com.jusdev.mvvm.model.PokemonDataModel
import com.jusdev.mvvm.ui.fragments.ClickListener
import com.jusdev.mvvm.ui.fragments.PokemosList
import com.jusdev.mvvm.ui.viewholder.ItemViewHolder

class ItemsAdapter(private val listener: ClickListener) : RecyclerView.Adapter<ItemViewHolder>() {

    private val resource = R.layout.pokemon_row
    lateinit var context: Context
    private val itemList = mutableListOf<PokemonDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        //rellenar el campo de los pokemon
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: PokemonRowBinding =
            DataBindingUtil.inflate(layoutInflater, resource, parent, false)
        return ItemViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //conexion
        holder.setItem(itemList[position])
        holder.itemView.setOnClickListener {
            listener.itemSelect(itemList[position])

            println("itemsView"+itemList)
            println("Escuchar" + listener)
        }

    }

    fun setItems(list: MutableList<PokemonDataModel>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

}


