package com.example.cloudservice

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

interface ProvideDatabase {
    
    fun database(): DatabaseReference
    
    class Base(application: Application) : ProvideDatabase {
        
        init {
            FirebaseApp.initializeApp(application)
        }
        
        override fun database(): DatabaseReference {
            return Firebase.database(DATABASE_URL).reference
        }
        
        companion object {
            private const val DATABASE_URL =
                "https://tools-294e4-default-rtdb.europe-west1.firebasedatabase.app/"
        }
    }
}