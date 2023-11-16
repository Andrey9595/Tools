package ru.anb.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class AuthRepositoryImpl : Auth {

    private val auth = FirebaseAuth.getInstance()

    override suspend fun signInWithGoogle(token: String) = suspendCoroutine { continuation ->
        val credential = GoogleAuthProvider.getCredential(token, null)
        auth.signInWithCredential(credential).addOnSuccessListener {
            val user = it.user
            if (user != null) {
                continuation.resume(User(user.displayName, user.email, user.phoneNumber, user.uid))
            } else continuation.resumeWithException(IllegalArgumentException("User is null"))
        }.addOnCanceledListener {
            continuation.resumeWithException(IllegalArgumentException())
        }
    }

    override fun signInWithPhone() {
        TODO("Not yet implemented")
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): User {
        val user = auth.signInWithEmailAndPassword(email, password).await().user!!
        return User(user.displayName, user.email, user.phoneNumber, user.uid)
    }

    override suspend fun signUpWithEmailAndPassword(email: String, password: String): User {
        val user = auth.createUserWithEmailAndPassword(email, password).await().user!!
        return User(user.displayName, user.email, user.phoneNumber, user.uid)
    }

    override fun logOut() {
        auth.signOut()
    }
}