package com.example.cloudstorage

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

interface ProvideStorage {

    fun storage(): StorageReference

    class Base() : ProvideStorage {

        override fun storage(): StorageReference {
            return FirebaseStorage.getInstance().getReferenceFromUrl(STORAGE_URL)
        }

        companion object {
            private const val STORAGE_URL =
                "gs://tools-294e4.appspot.com/"
        }
    }
}