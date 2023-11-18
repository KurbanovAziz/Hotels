package com.example.hotel.data.repostory

import com.example.hotel.data.base.BaseRepository
import com.example.hotel.data.mappers.toHotels
import com.example.hotel.data.remote.service.ApiService
import com.example.hotel.domain.repository.GetHotelsRepository
import javax.inject.Inject

class GetHotelsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BaseRepository(), GetHotelsRepository {

    override fun getHotels() = doRequest {
        apiService.getHotels().toHotels()
    }

}