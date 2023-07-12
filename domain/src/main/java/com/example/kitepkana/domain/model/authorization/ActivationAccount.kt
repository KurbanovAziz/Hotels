package com.example.kitepkana.domain.model.authorization

data class ActivationAccount(
    val code: String
)

data class ActivationAccountRes(
    val message: String
)

data class ResendActivationAccount(
    val email: String
)