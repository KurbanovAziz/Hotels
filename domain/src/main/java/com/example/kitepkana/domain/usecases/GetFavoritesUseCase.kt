package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.repository.FavoritesRepository
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val favoritesRepository: FavoritesRepository
    ) {
    fun getFavorites() = favoritesRepository.getFavorites()
}