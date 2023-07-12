package com.example.kitepkana.domain.model.authorization

import java.net.IDN

data class RegisterUsers(
    val username: String,
    val email: String,
    val password: String,
    val re_password: String
)

data class Users(
    val username: String,
    val email: String,
    val idn: Int
)