package com.example.hotel.domain.repository

import com.example.hotel.domain.entities.Reservation
import com.example.hotel.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GetReservationRepository {
    fun getReservation(): Flow<Resource<Reservation>>
}