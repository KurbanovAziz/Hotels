package com.example.kitepkana.domain.usecases.authorization

import com.example.kitepkana.domain.model.authorization.CreateJwtToken
import com.example.kitepkana.domain.repository.AuthorizationRepository
import javax.inject.Inject

class CreateJwtTokenUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) {
    fun createJwtToken(
        createJwtToken: com.example.kitepkana.domain.model.authorization.CreateJwtToken
    ) = authorizationRepository.createJwtToken(createJwtToken)
}