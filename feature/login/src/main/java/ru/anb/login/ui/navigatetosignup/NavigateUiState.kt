package ru.anb.login.ui.navigatetosignup

import ru.anb.core.UiState
import ru.anb.login.databinding.RegistrationViewBinding

interface NavigateUiState : UiState<RegistrationViewBinding> {

    class Initial : NavigateUiState {
        override fun update(binding: RegistrationViewBinding) = Unit

    }
}