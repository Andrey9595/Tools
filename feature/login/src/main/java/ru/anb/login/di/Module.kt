package ru.anb.login.di

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module
import ru.anb.auth.Auth
import ru.anb.auth.AuthRepositoryImpl
import ru.anb.login.data.EmailRepositoryImpl
import ru.anb.login.data.ForgotPasswordRepositoryImpl
import ru.anb.login.data.LoginWithPhoneRepositoryImpl
import ru.anb.login.domain.email.EmailFlowWrapper
import ru.anb.login.domain.email.EmailInteractor
import ru.anb.login.domain.email.EmailRepository
import ru.anb.login.domain.forgotpassword.ForgotPasswordFlowWrapper
import ru.anb.login.domain.forgotpassword.ForgotPasswordRepository
import ru.anb.login.domain.navigatetosignup.NavigateToSignUpFlowWrapper
import ru.anb.login.domain.phone.LoginWithPhoneRepository
import ru.anb.login.domain.phone.PhoneFlowWrapper
import ru.anb.login.domain.phone.PhoneInteractor
import ru.anb.login.ui.email.EmailViewModel
import ru.anb.login.ui.forgotpassword.ForgotPasswordDialogViewModel
import ru.anb.login.ui.navigatetosignup.NavigateToSignUpViewModel
import ru.anb.login.ui.phone.LoginWithPhoneViewModel

fun loginModule() = module {

    viewModelOf(::EmailViewModel)
    viewModelOf(::ForgotPasswordDialogViewModel)
    viewModelOf(::LoginWithPhoneViewModel)
    viewModelOf(::NavigateToSignUpViewModel)

    factory { EmailInteractor.Base(get()) } bind EmailInteractor::class

    factory { EmailRepositoryImpl(get()) } bind EmailRepository::class

    factory { AuthRepositoryImpl(androidApplication()) } bind Auth::class

    factory { EmailFlowWrapper.Base() } binds arrayOf(
        EmailFlowWrapper.Post::class,
        EmailFlowWrapper.Collect::class,
        EmailFlowWrapper.Mutable::class
    )

    factory { ForgotPasswordRepositoryImpl(get()) } bind ForgotPasswordRepository::class

    factory { ForgotPasswordFlowWrapper.Base() } binds arrayOf(
        ForgotPasswordFlowWrapper.Post::class,
        ForgotPasswordFlowWrapper.Collect::class,
        ForgotPasswordFlowWrapper.Mutable::class
    )

    factory { PhoneInteractor.Base(get()) } bind PhoneInteractor::class

    factory { LoginWithPhoneRepositoryImpl(get()) } bind LoginWithPhoneRepository::class

    factory { PhoneFlowWrapper.Base() } binds arrayOf(
        PhoneFlowWrapper.Post::class,
        PhoneFlowWrapper.Collect::class,
        PhoneFlowWrapper.Mutable::class
    )

    factory { NavigateToSignUpFlowWrapper.Base() } binds arrayOf(
        NavigateToSignUpFlowWrapper.Post::class,
        NavigateToSignUpFlowWrapper.Collect::class,
        NavigateToSignUpFlowWrapper.Mutable::class
    )
}