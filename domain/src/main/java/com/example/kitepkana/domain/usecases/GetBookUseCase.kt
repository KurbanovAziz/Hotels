package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.repository.BookRepository
import javax.inject.Inject

class GetBookUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    fun getBook(id : Int) = bookRepository.getBook(id)
}