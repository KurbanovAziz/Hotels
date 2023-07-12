package com.example.kitepkana.data.remote.service

import com.example.kitepkana.data.model.*
import com.example.kitepkana.domain.model.Favorites
import com.example.kitepkana.domain.model.ResultD
import retrofit2.http.*

interface ApiService {

    @GET("favorite/")
    suspend fun getFavorites(): List<Favorites>

    @POST("favorite/")
    suspend fun addFavorite(
        @Body addFavoriteModel: AddFavoriteModel
    ): AddFavoriteModel

    @DELETE("favorite/{id}/")
    suspend fun deleteFavorite(
        @Path("id") id: Int
    ): Int

    @GET("books/")
    suspend fun getBooks(): List<BooksModel>

    @GET("recommended_books/")
    suspend fun getRecommendedBooks(): List<BooksModel>


    @GET("read/book/{id}/")
    suspend fun getReadBooks(
        @Path("id") id: Int,
        @Query("page") page : Int
    ): ResultModel

    @GET("books/{id}/")
    suspend fun getDetailBooks(
        @Path("id") id: Int,
    ): DetailBookModel

    @POST("reviews/")
    suspend fun createReviews(
        @Body createReviewsModel: CreateReviewsModel
    ): CreateReviewsModel

    @GET("auth/profile/")
    suspend fun getProfile(): ProfileModel

    @GET("search_filter/")
    suspend fun searchFilter(
        @Query("q") search : String
    ): List<BooksModel>


}