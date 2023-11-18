package com.example.hotel.data.repostory

import com.example.hotel.data.base.BaseRepository
import com.example.hotel.data.mappers.toReservation
import com.example.hotel.data.remote.service.ApiService
import com.example.hotel.domain.repository.GetReservationRepository
import javax.inject.Inject

class GetReservationRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BaseRepository(), GetReservationRepository {

    override fun getReservation() = doRequest {
        apiService.getReservation().toReservation()
    }
}