package com.example.kitepkana.data.repostory

import com.example.kitepkana.data.base.BaseRepository
import com.example.kitepkana.data.mappers.fromRegistration
import com.example.kitepkana.data.mappers.toRegistration
import com.example.kitepkana.data.remote.service.ApiService
import com.example.kitepkana.domain.entities.Registration
import com.example.kitepkana.domain.repository.RegistrationRepository
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BaseRepository(), RegistrationRepository {

    override fun registrationUsers(registration: Registration) = doRequest {
        apiService.registrationUsers(registration.fromRegistration()).toRegistration()
    }
}