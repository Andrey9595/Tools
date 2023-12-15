package ru.anb.login.domain.phone

import android.app.Activity
import java.util.concurrent.CancellationException

interface PhoneInteractor {

    suspend fun signIn(phone: String, activity: Activity): LoginWithPhoneResult

    class Base(private val repository: LoginWithPhoneRepository) : PhoneInteractor {
        override suspend fun signIn(phone: String, activity: Activity): LoginWithPhoneResult {
            return try {
                val user = repository.signIn(phone, activity)
                LoginWithPhoneResult.Success(user)
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                LoginWithPhoneResult.Error(e.message ?: "Something went wrong")
            }
        }
    }
}