package com.example.kitepkana.data.mappers

import com.example.kitepkana.data.model.authorization.*
import com.example.kitepkana.domain.model.authorization.*

fun RegisterUsers.fromRegister() = RegisterUsersModel(
    username, email, password, re_password
)
fun RegisterUsersResponse.toRegister() = Users(
    username, email, id
)

fun ActivationAccount.fromActivation() = ActivationAccountModel(
    code
)
fun ResendActivationAccount.fromResendActivation() = ResendActivationAccountModel(
    email
)

fun ResendActivationAccountModel.toResendActivation() =
    ResendActivationAccount(
        email
    )
fun ActivationAccountResponse.toActivation() =
    ActivationAccountRes(
        message
    )

fun JwtTokenResponse.toJwtToken() = JwtToken(
    refresh, access
)

fun CreateJwtToken.fromJwtToken() = CreateJwtTokenModel(
    email, password
)