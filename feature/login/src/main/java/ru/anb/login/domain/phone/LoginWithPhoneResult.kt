package ru.anb.login.domain.phone

import ru.anb.auth.User
import ru.anb.login.ui.phone.LoginWithPhoneUiState

interface LoginWithPhoneResult {

    fun handle(flowWrapper: PhoneFlowWrapper.Post)

    class Success(user: User): LoginWithPhoneResult{
        override fun handle(flowWrapper: PhoneFlowWrapper.Post) {
          flowWrapper.post(LoginWithPhoneUiState.Success())
        }
    }

    class Error(private val message: String): LoginWithPhoneResult{
        override fun handle(flowWrapper: PhoneFlowWrapper.Post) {
           flowWrapper.post(LoginWithPhoneUiState.Error(message))
        }
    }
}