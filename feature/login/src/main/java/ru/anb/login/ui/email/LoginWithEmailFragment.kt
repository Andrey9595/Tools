package ru.anb.login.ui.email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import ru.anb.core.BaseFragment
import ru.anb.login.databinding.FragmentLoginWithEmailBinding

class LoginWithEmailFragment() : BaseFragment<FragmentLoginWithEmailBinding>() {

    override fun initBinding(inflater: LayoutInflater) =
        FragmentLoginWithEmailBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}