package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.repository.HotelsRepository
import javax.inject.Inject

class GetHotelsUseCase @Inject constructor(
    private val hotelsRepository: HotelsRepository
) {
    fun getHotels() = hotelsRepository.getHotels()
}