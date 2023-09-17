package com.example.kitepkana.data.remote.service

import com.example.kitepkana.data.models.*
import retrofit2.http.*

interface ApiService {

    @POST("registration/users")
    suspend fun registrationUsers(
        @Body registrationModel: RegistrationModel
    ): RegistrationModel
}