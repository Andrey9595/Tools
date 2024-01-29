package ru.anb.login.domain.phone

import android.app.Activity
import ru.anb.auth.User

interface LoginWithPhoneRepository {

    suspend fun signIn(phone: String, activity: Activity): User
}