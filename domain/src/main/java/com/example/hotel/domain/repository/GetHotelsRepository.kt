package com.example.hotel.domain.repository

import com.example.hotel.domain.entities.Hotels
import com.example.hotel.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GetHotelsRepository {
    fun getHotels(): Flow<Resource<Hotels>>
}