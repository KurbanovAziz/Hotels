package com.example.kitepkana.domain.repository

import com.example.kitepkana.domain.model.Books
import com.example.kitepkana.domain.model.DetailBook
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun searchFilter(search : String): Flow<Resource<List<com.example.kitepkana.domain.model.Books>>>

}