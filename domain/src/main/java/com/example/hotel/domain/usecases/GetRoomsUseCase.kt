package com.example.hotel.domain.usecases

import com.example.hotel.domain.repository.GetRoomsRepository
import javax.inject.Inject

class GetRoomsUseCase @Inject constructor(
    private val getRoomsRepository: GetRoomsRepository
) {
    fun getRooms() = getRoomsRepository.getRooms()
}