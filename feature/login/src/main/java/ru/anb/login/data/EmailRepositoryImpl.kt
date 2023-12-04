package ru.anb.login.data

import ru.anb.auth.Auth
import ru.anb.auth.User
import ru.anb.login.domain.EmailRepository

class EmailRepositoryImpl(private val auth: Auth) : EmailRepository {
    override suspend fun signIn(email: String, password: String): User {
        return auth.signInWithEmailAndPassword(email, password)

    }
}