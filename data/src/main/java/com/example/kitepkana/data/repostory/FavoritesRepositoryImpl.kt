package com.example.kitepkana.data.repostory

import com.example.kitepkana.data.base.BaseRepository
import com.example.kitepkana.data.mappers.fromFavorite
import com.example.kitepkana.data.mappers.toFavorite
import com.example.kitepkana.data.remote.service.ApiService
import com.example.kitepkana.domain.model.AddFavorite
import com.example.kitepkana.domain.repository.FavoritesRepository
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : com.example.kitepkana.data.base.BaseRepository(), FavoritesRepository {

    override fun getFavorites() = doRequest {
        apiService.getFavorites()
    }

    override fun addFavorite(addFavorite: AddFavorite): Flow<Resource<AddFavorite>> = doRequest {
        apiService.addFavorite(addFavorite.fromFavorite()).toFavorite()
    }

    override fun deleteFavorite(id: Int): Flow<Resource<Int>> = doRequest {
        apiService.deleteFavorite(id)
    }

}