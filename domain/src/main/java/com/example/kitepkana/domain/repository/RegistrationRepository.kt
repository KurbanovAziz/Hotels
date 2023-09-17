package com.example.kitepkana.domain.repository

import com.example.kitepkana.domain.entities.Registration
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RegistrationRepository {
    fun registrationUsers(registration: Registration): Flow<Resource<Registration>>
}