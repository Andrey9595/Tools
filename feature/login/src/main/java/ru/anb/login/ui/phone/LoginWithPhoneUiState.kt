package ru.anb.login.ui.phone

import android.view.View
import android.widget.Toast
import ru.anb.core.UiState
import ru.anb.login.databinding.FragmentLoginWithPhoneBinding

interface LoginWithPhoneUiState : UiState<FragmentLoginWithPhoneBinding> {
    class Initial : LoginWithPhoneUiState {
        override fun update(binding: FragmentLoginWithPhoneBinding) = Unit
    }

    class Success : LoginWithPhoneUiState {
        override fun update(binding: FragmentLoginWithPhoneBinding) {
            binding.progressBar.progressbar.visibility = View.INVISIBLE
        }
    }

    class Error(private val message: String) : LoginWithPhoneUiState {
        override fun update(binding: FragmentLoginWithPhoneBinding) {
            Toast.makeText(binding.root.context, message, Toast.LENGTH_LONG).show()
            binding.progressBar.progressbar.visibility = View.INVISIBLE
        }
    }

    class Loading : LoginWithPhoneUiState {
        override fun update(binding: FragmentLoginWithPhoneBinding) {
            binding.progressBar.progressbar.visibility = View.VISIBLE
        }
    }
}
