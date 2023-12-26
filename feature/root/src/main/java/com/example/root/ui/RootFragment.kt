package com.example.root.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.root.R
import com.example.root.databinding.FragmentRootBinding
import com.google.android.material.tabs.TabLayoutMediator
import ru.anb.core.BaseFragment

class RootFragment : BaseFragment<FragmentRootBinding>() {

    private lateinit var tabLayoutMediator: TabLayoutMediator

    private val icons = listOf(
        R.drawable.home,
        R.drawable.favorite,
        R.drawable.shopping_basket,
        R.drawable.account_profile
    )

    override fun initBinding(inflater: LayoutInflater) = FragmentRootBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RootAdapter(this)

        binding.viewPager.adapter = adapter

        tabLayoutMediator = TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            tab.text = resources.getStringArray(R.array.root_titles)[pos]
            tab.setIcon(icons[pos])
        }.apply { attach() }
    }
}