package com.example.kitepkana.domain.usecases.authorization

import com.example.kitepkana.domain.model.authorization.RegisterUsers
import com.example.kitepkana.domain.repository.AuthorizationRepository
import javax.inject.Inject

class RegisterUsersUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) {
    fun registerUsers(registerUsers: com.example.kitepkana.domain.model.authorization.RegisterUsers) =
        authorizationRepository.registerUsers(registerUsers)
}