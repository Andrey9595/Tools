package ru.anb.login.domain.forgotpassword

interface ForgotPasswordRepository {

   suspend fun resetPassword(email: String): ResetPasswordResult
}