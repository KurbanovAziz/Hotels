package com.example.kitepkana.domain.repository

import com.example.kitepkana.domain.model.Profile
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getProfile(): Flow<Resource<com.example.kitepkana.domain.model.Profile>>

}