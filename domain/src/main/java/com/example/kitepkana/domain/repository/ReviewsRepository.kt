package com.example.kitepkana.domain.repository

import com.example.kitepkana.domain.model.CreateReviews
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ReviewsRepository {

    fun createReviews(createReviews: com.example.kitepkana.domain.model.CreateReviews): Flow<Resource<com.example.kitepkana.domain.model.CreateReviews>>
}