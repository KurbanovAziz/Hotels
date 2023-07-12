package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.model.CreateReviews
import com.example.kitepkana.domain.repository.ReviewsRepository
import javax.inject.Inject

class CreateReviewsUseCase @Inject constructor(
    private val reviewsRepository: ReviewsRepository
) {
    fun createReviews(
        createReviews: com.example.kitepkana.domain.model.CreateReviews
    ) = reviewsRepository.createReviews(createReviews)
}