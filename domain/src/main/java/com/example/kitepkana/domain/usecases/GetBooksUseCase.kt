package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.repository.LibraryRepository
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val libraryRepository: LibraryRepository
    ) {
    fun getBooks() = libraryRepository.getBooks()
}