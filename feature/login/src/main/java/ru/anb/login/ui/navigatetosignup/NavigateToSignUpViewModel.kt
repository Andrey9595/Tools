package ru.anb.login.ui.navigatetosignup

import ru.anb.core.BaseViewModel
import ru.anb.core.Navigation
import ru.anb.login.domain.navigatetosignup.NavigateToSignUpFlowWrapper
import ru.anb.registration.ui.RegistrationFragment

class NavigateToSignUpViewModel(
    override val flowWrapper: NavigateToSignUpFlowWrapper.Mutable,
    private val navigation: Navigation
) : BaseViewModel<NavigateUiState>() {

    fun navigateToSignUp() {
        navigation.goAndAddToBackStack(RegistrationFragment::class.java)
    }
}