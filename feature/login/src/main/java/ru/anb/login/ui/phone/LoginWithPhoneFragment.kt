package ru.anb.login.ui.phone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import ru.anb.core.BaseFragment
import ru.anb.login.databinding.FragmentLoginWithPhoneBinding

class LoginWithPhoneFragment(): BaseFragment<FragmentLoginWithPhoneBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentLoginWithPhoneBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}