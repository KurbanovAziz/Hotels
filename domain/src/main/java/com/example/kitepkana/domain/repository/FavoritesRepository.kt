package com.example.kitepkana.domain.repository

import com.example.kitepkana.domain.model.AddFavorite
import com.example.kitepkana.domain.model.Favorites
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    fun getFavorites(): Flow<Resource<List<com.example.kitepkana.domain.model.Favorites>>>

    fun addFavorite(addFavorite: com.example.kitepkana.domain.model.AddFavorite): Flow<Resource<com.example.kitepkana.domain.model.AddFavorite>>

    fun deleteFavorite(id: Int): Flow<Resource<Int>>

}