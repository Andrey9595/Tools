package ru.anb.login.data

import android.app.Activity
import ru.anb.auth.Auth
import ru.anb.auth.User
import ru.anb.login.domain.phone.LoginWithPhoneRepository

class LoginWithPhoneRepositoryImpl(private val auth: Auth) : LoginWithPhoneRepository {
    override suspend fun signIn(phone: String, activity: Activity): User {
        return auth.signInWithPhone(phone, activity)
    }
}