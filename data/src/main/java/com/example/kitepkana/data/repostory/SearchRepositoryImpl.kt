package com.example.kitepkana.data.repostory

import com.example.kitepkana.data.base.BaseRepository
import com.example.kitepkana.data.mappers.toBooks
import com.example.kitepkana.data.mappers.toProfile
import com.example.kitepkana.data.remote.service.ApiService
import com.example.kitepkana.domain.model.Books
import com.example.kitepkana.domain.model.Profile
import com.example.kitepkana.domain.repository.ProfileRepository
import com.example.kitepkana.domain.repository.SearchRepository
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : com.example.kitepkana.data.base.BaseRepository(), SearchRepository {

    override fun searchFilter(search: String) = doListRequest{
        apiService.searchFilter(search).map { it.toBooks()}
    }

}