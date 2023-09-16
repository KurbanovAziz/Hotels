package com.example.kitepkana.data.repostory

import com.example.kitepkana.data.base.BaseRepository
import com.example.kitepkana.data.mappers.toHotels
import com.example.kitepkana.data.remote.service.ApiService
import com.example.kitepkana.domain.repository.HotelsRepository

import javax.inject.Inject

class HotelsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BaseRepository(), HotelsRepository {

    override fun getHotels() = doRequest {
        apiService.getHotels().toHotels()
    }
}