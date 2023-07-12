package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.model.AddFavorite
import com.example.kitepkana.domain.repository.FavoritesRepository
import javax.inject.Inject

class AddFavoritesUseCase @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) {
    fun addFavorite(
        addFavorite: com.example.kitepkana.domain.model.AddFavorite
    ) = favoritesRepository.addFavorite(addFavorite)
}