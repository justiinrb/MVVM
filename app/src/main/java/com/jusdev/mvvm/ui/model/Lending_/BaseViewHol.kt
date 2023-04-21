package com.jusdev.mvvm.ui.model.Lending_

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHol <T>(itemView: View): RecyclerView.ViewHolder(itemView){
    abstract fun bind(item:T,position: Int)
}