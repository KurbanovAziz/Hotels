package com.example.hotel.domain.repository

import com.example.hotel.domain.entities.Rooms
import com.example.hotel.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GetRoomsRepository {
    fun getRooms(): Flow<Resource<Rooms>>
}