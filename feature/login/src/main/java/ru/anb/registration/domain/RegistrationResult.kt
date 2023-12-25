package ru.anb.registration.domain

import ru.anb.auth.User
import ru.anb.registration.ui.RegistrationUiState

interface RegistrationResult {

    fun handle(flowWrapper: RegistrationFlowWrapper.Post)

    class Success(user: User) : RegistrationResult {
        override fun handle(flowWrapper: RegistrationFlowWrapper.Post) {
            flowWrapper.post(RegistrationUiState.Success())
        }
    }

    class Error(private val message: String) : RegistrationResult {
        override fun handle(flowWrapper: RegistrationFlowWrapper.Post) {
            flowWrapper.post(RegistrationUiState.Error(message))
        }
    }
}