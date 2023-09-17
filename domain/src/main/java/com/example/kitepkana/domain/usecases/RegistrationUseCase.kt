package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.entities.Registration
import com.example.kitepkana.domain.repository.RegistrationRepository
import javax.inject.Inject

class RegistrationUseCase @Inject constructor(
    private val registrtionRepository: RegistrationRepository
) {
    fun registrationUsers(registration: Registration) =
        registrtionRepository.registrationUsers(registration)
}