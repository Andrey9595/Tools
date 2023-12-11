package ru.anb.login.ui.forgotpassword

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.anb.core.BaseViewModel
import ru.anb.login.domain.forgotpassword.ForgotPasswordFlowWrapper
import ru.anb.login.domain.forgotpassword.ForgotPasswordRepository

class ForgotPasswordDialogViewModel(
    private val repository: ForgotPasswordRepository,
    override val flowWrapper: ForgotPasswordFlowWrapper.Mutable
) : BaseViewModel<ForgotPasswordDialogUiState>() {

    fun resetPassword(email: String) {
        flowWrapper.post(ForgotPasswordDialogUiState.Loading())
        viewModelScope.launch {
            val result = repository.resetPassword(email)
            result.handle(flowWrapper)
        }
    }
}