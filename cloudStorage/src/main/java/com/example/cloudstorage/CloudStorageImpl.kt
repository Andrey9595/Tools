package com.example.cloudstorage

import android.net.Uri
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class CloudStorageImpl(provideStorage: ProvideStorage) : CloudStorage {

    private val storage = provideStorage.storage()

    override suspend fun getDownloadUrl(fileReference: String): Uri {
        return suspendCoroutine { continuation ->
            storage.child(fileReference).downloadUrl.addOnSuccessListener {
                continuation.resume(it)
            }.addOnFailureListener {
                continuation.resumeWithException(it)
            }
        }
    }
}