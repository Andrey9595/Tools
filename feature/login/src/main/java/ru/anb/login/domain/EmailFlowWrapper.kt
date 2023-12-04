package ru.anb.login.domain

import ru.anb.core.FlowWrapper
import ru.anb.login.ui.email.EmailUiState

interface EmailFlowWrapper {

    interface Post : FlowWrapper.Post<EmailUiState>

    interface Collect : FlowWrapper.Collect<EmailUiState>

    interface Mutable : FlowWrapper.Mutable<EmailUiState>, Post, Collect

    class Base: FlowWrapper.Base<EmailUiState>(EmailUiState.Initial()), Mutable
}