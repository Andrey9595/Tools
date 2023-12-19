package ru.anb.registration.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.anb.core.BaseViewModel
import ru.anb.registration.domain.RegistrationFlowWrapper
import ru.anb.registration.domain.RegistrationInteractor

class RegistrationViewModel(
    private val registrationInteractor: RegistrationInteractor,
    override val flowWrapper: RegistrationFlowWrapper.Mutable,

    ) : BaseViewModel<RegistrationUiState>() {

    fun signUp(email: String, password: String) {
        flowWrapper.post(RegistrationUiState.Loading())
        viewModelScope.launch {
            val result = registrationInteractor.signIn(email, password)
            result.handle(flowWrapper)
        }
    }
}