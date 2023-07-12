package com.example.kitepkana.data.repostory

import com.example.kitepkana.data.base.BaseRepository
import com.example.kitepkana.data.mappers.toProfile
import com.example.kitepkana.data.remote.service.ApiService
import com.example.kitepkana.domain.model.Profile
import com.example.kitepkana.domain.repository.ProfileRepository
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : com.example.kitepkana.data.base.BaseRepository(), ProfileRepository {

    override fun getProfile(): Flow<Resource<Profile>> = doRequest {
        apiService.getProfile().toProfile()
    }

}