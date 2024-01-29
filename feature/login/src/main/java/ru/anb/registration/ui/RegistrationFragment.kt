package ru.anb.registration.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.anb.core.BaseFragment
import ru.anb.login.databinding.FragmentSignUpBinding

class RegistrationFragment : BaseFragment<FragmentSignUpBinding>() {

    private val viewModel: RegistrationViewModel by viewModel()
    private val client by lazy { Identity.getSignInClient(requireContext()) }
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            val token = client.getSignInCredentialFromIntent(result.data).googleIdToken
            token?.let { viewModel.handleToken(it) }
        }

    override fun initBinding(inflater: LayoutInflater): FragmentSignUpBinding =
        FragmentSignUpBinding.inflate(inflater)

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

            signUpButton.enterButton.setOnClickListener {

                val inputList = listOf(emailInput.emailInput, passwordLayout)
                val isValid = inputList.map { it.isValid() }
                if (isValid.all { it })
                    viewModel.signUp(
                        email = emailInput.emailInput.text(),
                        password = passwordLayout.text()
                    )
            }

            signUpWithGoogle.setOnClickListener {
                viewModel.startSignInWithGoogle(client, launcher)
            }
        }
    }

}