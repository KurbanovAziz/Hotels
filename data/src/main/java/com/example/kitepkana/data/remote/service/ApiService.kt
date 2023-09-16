package com.example.kitepkana.data.remote.service

import com.example.kitepkana.data.models.*
import retrofit2.http.*

interface ApiService {

    @GET("v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotels(): HotelsModel
}