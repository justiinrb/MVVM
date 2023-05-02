package com.jusdev.mvvm.ui.model.Lending_

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jusdev.mvvm.R

class Adapter_Operaciones(var operacions: List<Operacione>,val lending :Lending, val Listener: OnclickListener): RecyclerView.Adapter<Adapter_Operaciones.ViewHolderOper>() {


    interface OnclickListener{
        fun OnClick(item: Operacione, lending:Lending)

    }



    inner class ViewHolderOper(itemView:View):RecyclerView.ViewHolder(itemView){
        val docment: TextView = itemView.findViewById(R.id.doc1)
        val fecha: TextView = itemView.findViewById(R.id.fecha1)
        val balance: TextView = itemView.findViewById(R.id.balance1)

        val Linear : LinearLayout = itemView.findViewById(R.id.chil)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOper {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.child_lend1,parent,false)

        return ViewHolderOper(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolderOper, position: Int) {
       val currentPos = operacions[position]
        holder.docment.text = currentPos.DOCUMENTO
        holder.fecha.text = currentPos.FECHA
        holder.balance.text = currentPos.BALANCE

        holder.Linear.setOnClickListener {

            Listener.OnClick(currentPos,lending)
        }

    }

    override fun getItemCount() = operacions.size
}