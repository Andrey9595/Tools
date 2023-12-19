package ru.anb.registration.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module
import ru.anb.registration.data.RegistrationRepositoryImpl
import ru.anb.registration.domain.RegistrationFlowWrapper
import ru.anb.registration.domain.RegistrationInteractor
import ru.anb.registration.domain.RegistrationRepository
import ru.anb.registration.ui.RegistrationViewModel

fun registrationModule() = module {

    viewModelOf(::RegistrationViewModel)

    factory { RegistrationInteractor.Base(get()) } bind RegistrationInteractor::class

    factory { RegistrationRepositoryImpl(get()) } bind RegistrationRepository::class


    factory { RegistrationFlowWrapper.Base() } binds arrayOf(
        RegistrationFlowWrapper.Post::class,
        RegistrationFlowWrapper.Collect::class,
        RegistrationFlowWrapper.Mutable::class
    )
}