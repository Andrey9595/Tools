package ru.anb.login.domain.phone

interface PhoneInteractor {

    suspend fun signIn(phone: String): LoginWithPhoneResult
}