package com.example.kitepkana.data.repostory

import com.example.kitepkana.data.base.BaseRepository
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.data.mappers.*
import com.example.kitepkana.data.remote.service.AuthorizationService
import com.example.kitepkana.domain.model.authorization.ActivationAccount
import com.example.kitepkana.domain.model.authorization.CreateJwtToken
import com.example.kitepkana.domain.model.authorization.RegisterUsers
import com.example.kitepkana.domain.model.authorization.ResendActivationAccount
import com.example.kitepkana.domain.repository.AuthorizationRepository
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val authorizationService: AuthorizationService,
    private val appPrefs: AppPrefs,
) : com.example.kitepkana.data.base.BaseRepository(), AuthorizationRepository {

    override fun registerUsers(
        registerUsers: RegisterUsers
    ) = doRequest {
        authorizationService.registerUsers(registerUsers.fromRegister()).toRegister()
    }

    override fun activationAccount(activationAccount: ActivationAccount) = doRequest {
        authorizationService.activationAccount(activationAccount.fromActivation()).toActivation()
    }

    override fun resendActivationAccount(resendActivationAccount: ResendActivationAccount) =
        doRequest {
            authorizationService.resendActivationAccount(resendActivationAccount.fromResendActivation())
                .toResendActivation()
        }

    override fun createJwtToken(createJwtToken: CreateJwtToken) = doRequest {
        authorizationService.createJwtToken(createJwtToken.fromJwtToken()).also {
            appPrefs.jwtAccess = it.access
            appPrefs.jwtRefresh = it.refresh
        }.toJwtToken()
    }
}

