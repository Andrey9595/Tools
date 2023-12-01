package ru.anb.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import ru.anb.core.BaseFragment
import ru.anb.login.R
import ru.anb.login.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private lateinit var tabLayoutMediator: TabLayoutMediator

    override fun initBinding(inflater: LayoutInflater) = FragmentLoginBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = LoginAdapter(this)

        binding.viewPager.adapter = adapter

        tabLayoutMediator = TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            tab.text = resources.getStringArray(R.array.login_tabs)[pos]
        }.apply { attach() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tabLayoutMediator.detach()
    }
}