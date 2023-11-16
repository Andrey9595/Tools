package ru.anb.auth

data class User(
    val getDisplayName: String?,
    val email: String?,
    val phoneNumber: String?,
    val uid: String
)
