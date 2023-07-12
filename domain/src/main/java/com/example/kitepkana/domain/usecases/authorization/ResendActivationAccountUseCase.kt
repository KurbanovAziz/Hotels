package com.example.kitepkana.domain.usecases.authorization

import com.example.kitepkana.domain.model.authorization.ResendActivationAccount
import com.example.kitepkana.domain.repository.AuthorizationRepository
import javax.inject.Inject

class ResendActivationAccountUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) {
    fun getResendActivation(resendActivationAccount: com.example.kitepkana.domain.model.authorization.ResendActivationAccount) =
        authorizationRepository.resendActivationAccount(resendActivationAccount)
}