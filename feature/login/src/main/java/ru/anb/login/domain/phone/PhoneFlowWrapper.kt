package ru.anb.login.domain.phone

import ru.anb.core.FlowWrapper
import ru.anb.login.ui.phone.LoginWithPhoneUiState

interface PhoneFlowWrapper {

    interface Post : FlowWrapper.Post<LoginWithPhoneUiState>

    interface Collect : FlowWrapper.Collect<LoginWithPhoneUiState>

    interface Mutable : FlowWrapper.Mutable<LoginWithPhoneUiState>, Post, Collect

    class Base : FlowWrapper.Base<LoginWithPhoneUiState>(LoginWithPhoneUiState.Initial()), Mutable
}