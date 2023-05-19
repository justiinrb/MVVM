package com.jusdev.mvvm.ui.ui.BackUp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.viewpager2.adapter.FragmentStateAdapter


class Adapter_Pag2(

    Fm: FragmentManager,
    val fragmentList: ArrayList<Fragment>,
    lifecycle: Lifecycle
) : FragmentStateAdapter(Fm, lifecycle) {
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
      return fragmentList[position]
    }
}