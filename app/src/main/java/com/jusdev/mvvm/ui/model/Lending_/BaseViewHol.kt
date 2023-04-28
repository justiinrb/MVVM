package com.jusdev.mvvm.ui.model.Lending_

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jusdev.mvvm.R

abstract class BaseViewHol <T>(itemView: View): RecyclerView.ViewHolder(itemView){
    abstract fun bind(item:T, position: Int)



}

