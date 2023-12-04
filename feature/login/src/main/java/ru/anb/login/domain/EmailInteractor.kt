package ru.anb.login.domain

import kotlinx.coroutines.CancellationException

interface EmailInteractor {

    suspend fun signIn(email: String, password: String): LoginResult

    class Base(private val repository: EmailRepository) : EmailInteractor {
        override suspend fun signIn(email: String, password: String): LoginResult {
            return try {
                val user = repository.signIn(email, password)
                LoginResult.Success(user)
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                LoginResult.Error(e.message ?: "Something went wrong")
            }
        }
    }
}