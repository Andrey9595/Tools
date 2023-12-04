package ru.anb.login.domain

import ru.anb.auth.User
import ru.anb.login.ui.email.EmailUiState

interface LoginResult {

    fun handle(flowWrapper: EmailFlowWrapper.Post)

    class Success(user: User) : LoginResult {
        override fun handle(flowWrapper: EmailFlowWrapper.Post) {
           flowWrapper.post(EmailUiState.Success())
        }
    }

    class Error(private val message: String) : LoginResult {
        override fun handle(flowWrapper: EmailFlowWrapper.Post) {
          flowWrapper.post(EmailUiState.Error(message))
        }
    }
}