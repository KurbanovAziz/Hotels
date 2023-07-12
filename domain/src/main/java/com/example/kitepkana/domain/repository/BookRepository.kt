package com.example.kitepkana.domain.repository

import com.example.kitepkana.domain.model.DetailBook
import com.example.kitepkana.domain.model.ResultD
import com.example.kitepkana.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getBook(id : Int): Flow<Resource<com.example.kitepkana.domain.model.DetailBook>>

    fun getReadBook(id : Int,page : Int): Flow<Resource<com.example.kitepkana.domain.model.ResultD>>
}