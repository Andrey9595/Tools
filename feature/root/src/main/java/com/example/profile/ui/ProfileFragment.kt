package com.example.profile.ui

import android.view.LayoutInflater
import com.example.root.databinding.FragmentProfileBinding
import ru.anb.core.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentProfileBinding.inflate(inflater)
}