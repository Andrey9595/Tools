package ru.anb.registration.domain

import ru.anb.core.FlowWrapper
import ru.anb.registration.ui.RegistrationUiState

interface RegistrationFlowWrapper {

    interface Post : FlowWrapper.Post<RegistrationUiState>

    interface Collect : FlowWrapper.Collect<RegistrationUiState>

    interface Mutable : FlowWrapper.Mutable<RegistrationUiState>, Post, Collect

    class Base : FlowWrapper.Base<RegistrationUiState>(RegistrationUiState.Initial()), Mutable
}