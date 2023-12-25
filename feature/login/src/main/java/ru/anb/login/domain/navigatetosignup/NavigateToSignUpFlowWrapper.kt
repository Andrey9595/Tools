package ru.anb.login.domain.navigatetosignup

import ru.anb.core.FlowWrapper
import ru.anb.login.ui.navigatetosignup.NavigateUiState

interface NavigateToSignUpFlowWrapper {

    interface Post : FlowWrapper.Post<NavigateUiState>

    interface Collect : FlowWrapper.Collect<NavigateUiState>

    interface Mutable : FlowWrapper.Mutable<NavigateUiState>, Post, Collect

    class Base: FlowWrapper.Base<NavigateUiState>(NavigateUiState.Initial()), Mutable
}