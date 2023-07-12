package com.example.kitepkana.data.repostory

import com.example.kitepkana.data.base.BaseRepository
import com.example.kitepkana.data.mappers.toDetailBook
import com.example.kitepkana.data.mappers.toReadBook
import com.example.kitepkana.data.remote.service.ApiService
import com.example.kitepkana.domain.model.DetailBook
import com.example.kitepkana.domain.repository.BookRepository
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : com.example.kitepkana.data.base.BaseRepository(), BookRepository {

    override fun getBook(id: Int): Flow<Resource<DetailBook>> = doRequest {
        apiService.getDetailBooks(id).toDetailBook()
    }

    override fun getReadBook(id: Int,page : Int) = doRequest {
        apiService.getReadBooks(id,page).toReadBook()
    }
}