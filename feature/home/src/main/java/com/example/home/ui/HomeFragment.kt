package com.example.home.ui

import android.view.LayoutInflater
import com.example.home.databinding.FragmentHomeBinding
import ru.anb.core.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)
}