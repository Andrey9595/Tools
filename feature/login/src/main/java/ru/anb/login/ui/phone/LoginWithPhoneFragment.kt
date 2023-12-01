package ru.anb.login.ui.phone

import android.view.LayoutInflater
import ru.anb.core.BaseFragment
import ru.anb.login.databinding.FragmentLoginWithPhoneBinding

class LoginWithPhoneFragment(): BaseFragment<FragmentLoginWithPhoneBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentLoginWithPhoneBinding.inflate(inflater)

}