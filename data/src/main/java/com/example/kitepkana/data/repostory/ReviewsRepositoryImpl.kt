package com.example.kitepkana.data.repostory

import com.example.kitepkana.data.base.BaseRepository
import com.example.kitepkana.data.mappers.fromReviews
import com.example.kitepkana.data.mappers.toReviews
import com.example.kitepkana.data.remote.service.ApiService
import com.example.kitepkana.domain.model.CreateReviews
import com.example.kitepkana.domain.repository.ReviewsRepository
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReviewsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : com.example.kitepkana.data.base.BaseRepository(), ReviewsRepository {

    override fun createReviews(createReviews: CreateReviews): Flow<Resource<CreateReviews>> =
        doRequest {
            apiService.createReviews(createReviews.fromReviews()).toReviews()
        }
}