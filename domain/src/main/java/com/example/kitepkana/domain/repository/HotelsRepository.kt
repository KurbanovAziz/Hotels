package com.example.kitepkana.domain.repository

import com.example.kitepkana.domain.entities.Hotels
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface HotelsRepository {
    fun getHotels(): Flow<Resource<Hotels>>
}