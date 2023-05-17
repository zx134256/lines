package com.hy.myapplication.ui.home

import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle,fragments : List<Fragment>) :
    FragmentStateAdapter(fragmentManager, lifecycle) {


    private var fragmenList : List<Fragment>? = null

    init {
        fragmenList = fragments
    }


    override fun getItemCount(): Int {
        return fragmenList!!.count()
    }

    override fun createFragment(position: Int): Fragment {
        return fragmenList!![position]
    }

}