package com.example.kitepkana.domain.repository

import com.example.kitepkana.domain.model.authorization.*
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthorizationRepository {

    fun registerUsers(
        registerUsers: RegisterUsers
    ): Flow<Resource<Users>>

    fun activationAccount(activationAccount: ActivationAccount): Flow<Resource<ActivationAccountRes>>

    fun resendActivationAccount(resendActivationAccount: ResendActivationAccount): Flow<Resource<ResendActivationAccount>>

    fun createJwtToken(createJwtToken: CreateJwtToken): Flow<Resource<JwtToken>>

}