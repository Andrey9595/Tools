package ru.anb.login.data

import ru.anb.auth.Auth
import ru.anb.login.domain.forgotpassword.ForgotPasswordRepository
import ru.anb.login.domain.forgotpassword.ResetPasswordResult

class ForgotPasswordRepositoryImpl(private val auth: Auth) : ForgotPasswordRepository {
    override suspend fun resetPassword(email: String): ResetPasswordResult {
        return try {
            auth.resetPassword(email)
            ResetPasswordResult.Success()
        } catch (e: Exception) {
            ResetPasswordResult.Error(e.message ?: " ")
        }
    }
}