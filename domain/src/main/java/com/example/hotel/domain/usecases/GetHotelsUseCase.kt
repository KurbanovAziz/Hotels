package com.example.hotel.domain.usecases

import com.example.hotel.domain.repository.GetHotelsRepository
import javax.inject.Inject

class GetHotelsUseCase @Inject constructor(
    private val getHotelsRepository: GetHotelsRepository
) {
    fun getHotels() = getHotelsRepository.getHotels()
}