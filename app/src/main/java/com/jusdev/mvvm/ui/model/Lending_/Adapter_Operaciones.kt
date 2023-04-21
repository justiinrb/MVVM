package com.jusdev.mvvm.ui.model.Lending_

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jusdev.mvvm.R

class Adapter_Operaciones(var context: Context, var operacions: List<Operacione>): RecyclerView.Adapter<BaseViewHol<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHol<*> {
        return Operator(LayoutInflater.from(context).inflate(R.layout.child_lend1,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHol<*>, position: Int) {
        when(holder){
            is Operator -> holder.bind(operacions[position],position)
            else -> IllegalArgumentException("no funciona ")

        }
    }

    override fun getItemCount(): Int = operacions.size


    inner class Operator(itemView : View):BaseViewHol<Operacione>(itemView) {
        override fun bind(item: Operacione, position: Int) {
            val doc: TextView
            doc = itemView.findViewById(R.id.doc1)
            doc.text = item.DOCUMENTO

            println("documentos"+ item.DOCUMENTO)

            val fech: TextView
            fech = itemView.findViewById(R.id.fecha1)
            fech.text = item.FECHA

            println("Fechas"+item.FECHA)


            val balan: TextView
            balan = itemView.findViewById(R.id.balance1)
            balan.text = item.BALANCE






        }
    }
}