package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.repository.ProfileRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
    ) {
    fun getProfile() = profileRepository.getProfile()
}