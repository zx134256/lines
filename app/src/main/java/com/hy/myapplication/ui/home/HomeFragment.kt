package com.hy.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hy.myapplication.databinding.FragmentHomeBinding
import com.hy.myapplication.ui.fragment.DiscussFragment
import com.hy.myapplication.ui.fragment.DiscussTwoFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var list = ArrayList<Fragment>()
        list.add(DiscussFragment())
        list.add(DiscussTwoFragment())
        binding.viewpager.adapter = MainAdapter(childFragmentManager,lifecycle,list)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}