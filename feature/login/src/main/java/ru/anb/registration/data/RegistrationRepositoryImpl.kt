package ru.anb.registration.data

import ru.anb.auth.Auth
import ru.anb.auth.User
import ru.anb.registration.domain.RegistrationRepository

class RegistrationRepositoryImpl(private val auth: Auth) : RegistrationRepository {

    override suspend fun signUp(email: String, password: String): User {
        return auth.signUpWithEmailAndPassword(email, password)
    }
}