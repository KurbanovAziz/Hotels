package com.example.kitepkana.domain.repository

import com.example.kitepkana.domain.model.Books
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface LibraryRepository {

    fun getBooks(): Flow<Resource<List<com.example.kitepkana.domain.model.Books>>>

    fun getRecommendedBooks(): Flow<Resource<List<com.example.kitepkana.domain.model.Books>>>

}