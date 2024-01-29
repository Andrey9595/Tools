package ru.anb.login.ui.forgotpassword

import android.view.View
import android.widget.Toast
import ru.anb.core.UiState
import ru.anb.login.databinding.DialogForgotPasswordBinding

interface ForgotPasswordDialogUiState : UiState<DialogForgotPasswordBinding> {

    class Initial : ForgotPasswordDialogUiState {
        override fun update(binding: DialogForgotPasswordBinding) = Unit

    }

    class Success : ForgotPasswordDialogUiState {
        override fun update(binding: DialogForgotPasswordBinding) {
            binding.progressbar.root.visibility = View.INVISIBLE
        }
    }

    class Loading : ForgotPasswordDialogUiState {
        override fun update(binding: DialogForgotPasswordBinding) {
            binding.progressbar.root.visibility = View.VISIBLE
        }
    }

    class Error(private val message: String) : ForgotPasswordDialogUiState {
        override fun update(binding: DialogForgotPasswordBinding) {
            binding.progressbar.root.visibility = View.INVISIBLE
            Toast.makeText(binding.root.context, message, Toast.LENGTH_SHORT).show()
        }
    }
}