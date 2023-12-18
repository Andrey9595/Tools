package ru.anb.registration.ui

import android.view.LayoutInflater
import ru.anb.core.BaseFragment
import ru.anb.login.databinding.FragmentSignUpBinding

class RegistrationFragment() : BaseFragment<FragmentSignUpBinding>() {


    override fun initBinding(inflater: LayoutInflater): FragmentSignUpBinding =
        FragmentSignUpBinding.inflate(inflater)

}