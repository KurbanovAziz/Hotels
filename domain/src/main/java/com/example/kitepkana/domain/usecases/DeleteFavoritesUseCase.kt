package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.repository.FavoritesRepository
import javax.inject.Inject

class DeleteFavoritesUseCase @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) {
    fun deleteFavorite(
        id: Int
    ) = favoritesRepository.deleteFavorite(id)
}