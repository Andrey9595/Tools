package ru.anb.auth

interface Auth {

    suspend fun signInWithGoogle(token: String): User

    fun signInWithPhone()

    suspend fun signInWithEmailAndPassword(email: String, password: String): User

    suspend fun signUpWithEmailAndPassword(email: String, password: String): User

    fun logOut()
}