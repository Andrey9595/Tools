package ru.anb.login.ui.email

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.anb.core.BaseViewModel
import ru.anb.login.domain.email.EmailFlowWrapper
import ru.anb.login.domain.email.EmailInteractor

class EmailViewModel(
    private val emailInteractor: EmailInteractor,
    override val flowWrapper: EmailFlowWrapper.Mutable
) : BaseViewModel<EmailUiState>() {

    fun signIn(email: String, password: String) {
        flowWrapper.post(EmailUiState.Loading())
        viewModelScope.launch {
            val result = emailInteractor.signIn(email, password)
            result.handle(flowWrapper)
        }
    }
}