package ru.anb.login.domain.forgotpassword

import ru.anb.core.FlowWrapper
import ru.anb.login.ui.forgotpassword.ForgotPasswordDialogUiState

interface ForgotPasswordFlowWrapper {

    interface Post : FlowWrapper.Post<ForgotPasswordDialogUiState>

    interface Collect : FlowWrapper.Collect<ForgotPasswordDialogUiState>

    interface Mutable : FlowWrapper.Mutable<ForgotPasswordDialogUiState>, Post, Collect

    class Base : FlowWrapper.Base<ForgotPasswordDialogUiState>(ForgotPasswordDialogUiState.Initial()), Mutable
}