package ru.anb.auth

import android.app.Activity
import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.tasks.await
import java.util.concurrent.TimeUnit
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class AuthRepositoryImpl(application: Context) : Auth {

    init {
        FirebaseApp.initializeApp(application)
    }

    private val auth = FirebaseAuth.getInstance()

    override suspend fun signInWithGoogle(token: String): User = suspendCoroutine { continuation ->
        val credential = GoogleAuthProvider.getCredential(token, null)
        signInWithCredential(credential, continuation)
    }

    override suspend fun signInWithPhone(phoneNumber: String, activity: Activity): User =
        suspendCoroutine { continuation ->
            val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    signInWithCredential(credential, continuation)
                }

                override fun onVerificationFailed(p0: FirebaseException) {
                    continuation.resumeWithException(p0)
                }
            }
            val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(phoneNumber) // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(activity) // Activity (for callback binding)
                .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
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

    override suspend fun resetPassword(email: String) = suspendCoroutine { contination ->
        auth.sendPasswordResetEmail(email).addOnSuccessListener {
            contination.resume(Unit)
        }.addOnFailureListener {
            contination.resumeWithException(it)
        }
    }

    private fun signInWithCredential(credential: AuthCredential, continuation: Continuation<User>) {
        auth.signInWithCredential(credential).addOnSuccessListener {
            val user = it.user
            if (user != null) {
                continuation.resume(User(user.displayName, user.email, user.phoneNumber, user.uid))
            } else continuation.resumeWithException(IllegalArgumentException("User is null"))
        }.addOnCanceledListener {
            continuation.resumeWithException(IllegalArgumentException())
        }
    }
}