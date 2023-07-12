package com.example.kitepkana.data.model.authorization

data class CreateJwtTokenModel(
    val email: String,
    val password: String
)

data class JwtTokenResponse(
    val access: String,
    val refresh: String
)