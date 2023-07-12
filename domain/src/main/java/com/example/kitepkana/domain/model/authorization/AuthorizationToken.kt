package com.example.kitepkana.domain.model.authorization

data class CreateJwtToken(
    val email: String,
    val password: String
)

data class JwtToken(
    val access: String,
    val refresh: String
)