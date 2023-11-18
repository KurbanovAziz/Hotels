package com.example.hotel.domain.usecases

import com.example.hotel.domain.repository.GetReservationRepository
import javax.inject.Inject

class GetReservationUseCase @Inject constructor(
    private val getReservationRepository: GetReservationRepository
) {
    fun getReservation() = getReservationRepository.getReservation()
}