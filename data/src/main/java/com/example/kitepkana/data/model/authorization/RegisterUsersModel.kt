package com.example.kitepkana.data.model.authorization

data class RegisterUsersModel(
    val username: String,
    val email: String,
    val password: String,
    val re_password: String
)

data class RegisterUsersResponse(
    val username: String,
    val email: String,
    val id: Int
)