package com.example.kitepkana.data.model.authorization

data class ActivationAccountModel(
    val code: String
)
data class ActivationAccountResponse(
    val message: String
)
data class ResendActivationAccountModel(
    val email: String
)