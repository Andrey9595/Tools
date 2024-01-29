package ru.anb.login.ui.email

import android.view.View
import android.widget.Toast
import ru.anb.core.UiState
import ru.anb.login.databinding.FragmentLoginWithEmailBinding

interface EmailUiState : UiState<FragmentLoginWithEmailBinding> {

    class Initial : EmailUiState {

        override fun update(binding: FragmentLoginWithEmailBinding) = Unit

    }

    class Loading : EmailUiState {
        override fun update(binding: FragmentLoginWithEmailBinding) {
            binding.progressbar.progressbar.visibility = View.VISIBLE
        }

    }

    class Success : EmailUiState {
        override fun update(binding: FragmentLoginWithEmailBinding) {
            binding.progressbar.progressbar.visibility = View.INVISIBLE
        }
    }

    class Error(private val message: String) : EmailUiState {
        override fun update(binding: FragmentLoginWithEmailBinding) {
            Toast.makeText(binding.root.context, message, Toast.LENGTH_LONG).show()
            binding.progressbar.progressbar.visibility = View.INVISIBLE
        }

    }
}