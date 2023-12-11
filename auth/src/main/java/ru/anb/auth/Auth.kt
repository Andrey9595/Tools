package ru.anb.auth

import android.app.Activity

interface Auth {

    suspend fun signInWithGoogle(token: String): User

   suspend fun signInWithPhone(phoneNumber: String, activity: Activity)

    suspend fun signInWithEmailAndPassword(email: String, password: String): User

    suspend fun signUpWithEmailAndPassword(email: String, password: String): User

    fun logOut()

    suspend fun resetPassword(email: String)
}