package ru.anb.login.domain.forgotpassword

import ru.anb.login.ui.forgotpassword.ForgotPasswordDialogUiState

interface ResetPasswordResult {

    fun handle(flowWrapper: ForgotPasswordFlowWrapper.Post)

    class Success() : ResetPasswordResult {
        override fun handle(flowWrapper: ForgotPasswordFlowWrapper.Post) {
            flowWrapper.post(ForgotPasswordDialogUiState.Success())
        }
    }

    class Error(private val message: String) : ResetPasswordResult {
        override fun handle(flowWrapper: ForgotPasswordFlowWrapper.Post) {
            flowWrapper.post(ForgotPasswordDialogUiState.Error(message))
        }
    }
}