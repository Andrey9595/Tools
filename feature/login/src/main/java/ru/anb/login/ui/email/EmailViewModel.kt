package ru.anb.login.ui.email

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.anb.core.BaseViewModel
import ru.anb.login.domain.EmailFlowWrapper
import ru.anb.login.domain.EmailInteractor

class EmailViewModel(
    private val emailInteractor: EmailInteractor,
    override val flowWrapper: EmailFlowWrapper.Mutable
) : BaseViewModel<EmailUiState>() {

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            val result = emailInteractor.signIn(email, password)
            result.handle(flowWrapper)
        }
    }
}