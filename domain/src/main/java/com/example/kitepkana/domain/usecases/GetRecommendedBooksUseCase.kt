package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.repository.LibraryRepository
import javax.inject.Inject

class GetRecommendedBooksUseCase @Inject constructor(
    private val libraryRepository: LibraryRepository
    ) {
    fun getRecommendedBooks() = libraryRepository.getBooks()
}