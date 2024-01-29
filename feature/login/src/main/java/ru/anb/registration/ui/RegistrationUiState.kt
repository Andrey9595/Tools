package ru.anb.registration.ui

import android.view.View
import android.widget.Toast
import ru.anb.core.UiState
import ru.anb.login.databinding.FragmentSignUpBinding

interface RegistrationUiState : UiState<FragmentSignUpBinding> {


    class Initial : RegistrationUiState {
        override fun update(binding: FragmentSignUpBinding) = Unit

    }

    class Loading : RegistrationUiState {
        override fun update(binding: FragmentSignUpBinding) {
            binding.progressbar.progressbar.visibility = View.VISIBLE
        }
    }

    class Success : RegistrationUiState {
        override fun update(binding: FragmentSignUpBinding) {
            binding.progressbar.progressbar.visibility = View.INVISIBLE
        }
    }

    class Error(private val message: String) : RegistrationUiState {
        override fun update(binding: FragmentSignUpBinding) {
            Toast.makeText(binding.root.context, message, Toast.LENGTH_SHORT).show()
            binding.progressbar.progressbar.visibility = View.INVISIBLE
        }
    }
}
