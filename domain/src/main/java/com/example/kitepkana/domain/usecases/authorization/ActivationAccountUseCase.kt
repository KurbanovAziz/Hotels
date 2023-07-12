package com.example.kitepkana.domain.usecases.authorization

import com.example.kitepkana.domain.model.authorization.ActivationAccount
import com.example.kitepkana.domain.repository.AuthorizationRepository
import javax.inject.Inject

class ActivationAccountUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) {
    fun getActivation(activationAccount: com.example.kitepkana.domain.model.authorization.ActivationAccount) =
        authorizationRepository.activationAccount(activationAccount)
}