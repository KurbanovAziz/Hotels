package com.example.hotel.data.remote.service

import com.example.hotel.data.models.*
import retrofit2.http.*

interface ApiService {
    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotels(): HotelsModel

    @GET("8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getRooms(): RoomsModel

    @GET("63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getReservation(): ReservationModel
}