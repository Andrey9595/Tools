package ru.anb.registration.domain

import ru.anb.auth.User

interface RegistrationRepository {

    suspend  fun signUp(email: String, password: String): User

    suspend fun signInWithGoogle(token: String): User
}