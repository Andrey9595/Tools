package ru.anb.registration.domain

import kotlinx.coroutines.CancellationException

interface RegistrationInteractor {

    suspend fun signIn(email: String, password: String): RegistrationResult

    suspend fun signInWithGoogle(token: String): RegistrationResult

    class Base(private val repository: RegistrationRepository) : RegistrationInteractor {
        override suspend fun signIn(email: String, password: String): RegistrationResult {
            return try {
                val user = repository.signUp(email, password)
                RegistrationResult.Success(user)
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                RegistrationResult.Error(e.message ?: "Something went wrong")
            }
        }

        override suspend fun signInWithGoogle(token: String): RegistrationResult {
            return try {
                val user = repository.signInWithGoogle(token)
                RegistrationResult.Success(user)
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                RegistrationResult.Error(e.message ?: "Something went wrong")
            }
        }
    }
}