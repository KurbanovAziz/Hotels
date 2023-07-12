package com.example.kitepkana.presentation.ui.fragments.library

import com.example.kitepkana.domain.model.Books
import com.example.kitepkana.domain.usecases.GetBooksUseCase
import com.example.kitepkana.domain.usecases.GetRecommendedBooksUseCase
import com.example.kitepkana.presentation.base.BaseViewModel
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase,
    private val getRecommendedBooksUseCase: GetRecommendedBooksUseCase,
) : BaseViewModel() {


    private val _getBooksState = MutableStateFlow<UIState<List<com.example.kitepkana.domain.model.Books>>>(UIState.Empty())
    val getBooksState = _getBooksState.asStateFlow()

    fun getBooks() {
        getBooksUseCase.getBooks().listCollectData(_getBooksState)
    }

    private val _getRecommendedBooksState = MutableStateFlow<UIState<List<com.example.kitepkana.domain.model.Books>>>(UIState.Empty())
    val getRecommendedBooksState = _getRecommendedBooksState.asStateFlow()

    fun getRecommendedBooks() {
        getRecommendedBooksUseCase.getRecommendedBooks().listCollectData(_getRecommendedBooksState)
    }
}