package com.example.kitepkana.domain.usecases

import com.example.kitepkana.domain.repository.SearchRepository
import javax.inject.Inject

class SearchFilterUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
    fun searchFilter(
        search: String
    ) = searchRepository.searchFilter(search)
}