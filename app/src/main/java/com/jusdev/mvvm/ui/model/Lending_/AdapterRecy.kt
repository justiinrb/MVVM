package com.jusdev.mvvm.ui.model.Lending_


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jusdev.mvvm.R


class AdapterRecy(var context: Context, var contenlendX: List<Lending>) :
    RecyclerView.Adapter<BaseViewHol<*>>() {


    /*fun empresa (id : List<Empresa_lend>, nombre : List<Empresa_lend>, context: Context){
        this.contenlendX = id
        this.contenlendX = nombre
        this.context = context
    }*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHol<*> {

        return Adap(LayoutInflater.from(context).inflate(R.layout.fragment_lend1, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHol<*>, position: Int) {
        when (holder) {
            is Adap -> holder.bind(contenlendX[position], position)
            else -> IllegalArgumentException("no funciona ")

        }


    }

    override fun getItemCount(): Int = contenlendX.size

    inner class Adap(itemView: View) : BaseViewHol<Lending>(itemView) {
        override fun bind(item: Lending, position: Int) {

            lateinit var adapter: Adapter_Operaciones

            val x: TextView
            x = itemView.findViewById(R.id.titleTv)
            x.text = item.nombre

            var layautmanayer: LinearLayoutManager? = null
            val r: RecyclerView
            r = itemView.findViewById(R.id.recy2)
            layautmanayer = LinearLayoutManager(context)
            r.layoutManager = layautmanayer
            adapter = Adapter_Operaciones(context, item.operaciones)
            r.adapter = adapter
            println(item.operaciones)
        }

    }
}





