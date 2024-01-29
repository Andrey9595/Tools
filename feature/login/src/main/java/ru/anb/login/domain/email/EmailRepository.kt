package ru.anb.login.domain.email

import ru.anb.auth.User

interface EmailRepository {

  suspend  fun signIn(email: String, password: String): User
}