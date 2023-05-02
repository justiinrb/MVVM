package com.jusdev.mvvm.ui.model.Lending_


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jusdev.mvvm.R


class AdapterRecy(var context: Context, private var contenlendX: List<Lending>,val listener : Adapter_Operaciones.OnclickListener) :
    RecyclerView.Adapter<AdapterRecy.Viewhold>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewhold {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_lend1, parent, false)
        return Viewhold(itemView)
    }

    override fun onBindViewHolder(holder: Viewhold, position: Int) {
        val currentItem = contenlendX[position]
        holder.nombre.text = currentItem.nombre

        holder.childrecy.setHasFixedSize(true)
        holder.childrecy.layoutManager = GridLayoutManager(holder.itemView.context, 1)

        val adapter = Adapter_Operaciones(currentItem.operaciones,currentItem,listener)
        holder.childrecy.adapter = adapter

        val isvisible: Boolean = currentItem.visibility

        holder.expand.visibility = if (isvisible) View.VISIBLE else View.GONE

        holder.butt.setOnClickListener {

            currentItem.visibility = !currentItem.visibility

            notifyItemChanged(position)
        }


    }

    override fun getItemCount() = contenlendX.size

    inner class Viewhold(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val nombre: TextView = itemView.findViewById(R.id.titleTv)
        val childrecy: RecyclerView = itemView.findViewById(R.id.recy2)

        val expand: LinearLayout = itemView.findViewById(R.id.expandle)
        val butt: AppCompatImageView = itemView.findViewById(R.id.ivexpand)




    }

}






