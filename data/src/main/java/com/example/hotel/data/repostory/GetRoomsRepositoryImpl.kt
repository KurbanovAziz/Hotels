package com.example.hotel.data.repostory

import com.example.hotel.data.base.BaseRepository
import com.example.hotel.data.mappers.toRooms
import com.example.hotel.data.remote.service.ApiService
import com.example.hotel.domain.repository.GetRoomsRepository
import javax.inject.Inject

class GetRoomsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BaseRepository(), GetRoomsRepository {
    override fun getRooms() = doRequest {
        apiService.getRooms().toRooms()
    }
}