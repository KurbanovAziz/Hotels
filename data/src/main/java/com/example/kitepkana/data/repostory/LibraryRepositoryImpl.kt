package com.example.kitepkana.data.repostory

import com.example.kitepkana.data.base.BaseRepository
import com.example.kitepkana.data.mappers.toBooks
import com.example.kitepkana.data.remote.service.ApiService
import com.example.kitepkana.domain.model.Books
import com.example.kitepkana.domain.repository.LibraryRepository
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LibraryRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : com.example.kitepkana.data.base.BaseRepository(), LibraryRepository {

    override fun getBooks(): Flow<Resource<List<Books>>> = doListRequest {
        apiService.getBooks().map { it.toBooks() }
    }

    override fun getRecommendedBooks(): Flow<Resource<List<Books>>> = doListRequest{
        apiService.getRecommendedBooks().map { it.toBooks() }
    }
}