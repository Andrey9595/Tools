package ru.anb.login.ui.email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.anb.core.BaseFragment
import ru.anb.login.databinding.FragmentLoginWithEmailBinding
import ru.anb.login.ui.forgotpassword.ForgotPasswordDialog

class LoginWithEmailFragment() : BaseFragment<FragmentLoginWithEmailBinding>() {

    private val viewModel: EmailViewModel by viewModel()
    override fun initBinding(inflater: LayoutInflater) =
        FragmentLoginWithEmailBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.collect {
                    it.update(binding)
                }
            }
        }
        with(binding) {
            enterButton.setOnClickListener {
                viewModel.signIn(email = emailInput.emailInput.text(), password = passwordInput.text())

            }
            forgotPassword.setOnClickListener {
                val dialog = ForgotPasswordDialog()
                dialog.show(parentFragmentManager, null)
            }
        }
    }

}