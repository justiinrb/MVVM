package com.jusdev.mvvm.ui.ui.documents.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewAdapt(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(
    supportFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    private val mfragmentList = ArrayList<Fragment>()
    private var mfragmenTitleList = ArrayList<String>()


    override fun getCount(): Int {
        return mfragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return mfragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mfragmenTitleList[position]
    }


    fun addFragment(fragment: Fragment,title:String ) {
        mfragmentList.add(fragment)
        mfragmenTitleList.add((title))

    }


}