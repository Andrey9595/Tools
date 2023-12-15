package ru.anb.login.ui.phone

import android.app.Activity
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.anb.core.BaseViewModel
import ru.anb.login.domain.phone.PhoneFlowWrapper
import ru.anb.login.domain.phone.PhoneInteractor

class LoginWithPhoneViewModel(
    private val interactor: PhoneInteractor,
    override val flowWrapper: PhoneFlowWrapper.Mutable
) : BaseViewModel<LoginWithPhoneUiState>() {

    fun signIn(phone: String, activity: Activity) {
        flowWrapper.post(LoginWithPhoneUiState.Loading())
        viewModelScope.launch {
            val result = interactor.signIn(phone, activity)
            result.handle(flowWrapper)
        }
    }
}