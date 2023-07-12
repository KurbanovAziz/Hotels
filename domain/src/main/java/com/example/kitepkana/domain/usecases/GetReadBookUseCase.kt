package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.repository.BookRepository
import javax.inject.Inject

class GetReadBookUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    fun getReadBook(id: Int, page: Int) = bookRepository.getReadBook(id, page)
}