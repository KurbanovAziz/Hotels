package com.example.kitepkana.presentation.ui.fragments.reviews

import com.example.kitepkana.domain.model.DetailBook
import com.example.kitepkana.domain.usecases.GetBookUseCase
import com.example.kitepkana.presentation.base.BaseViewModel
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class ReviewsViewModel @Inject constructor(
    private val getBookUseCase: GetBookUseCase,
) : BaseViewModel() {

    private val _getBookState = MutableStateFlow<UIState<com.example.kitepkana.domain.model.DetailBook>>(UIState.Empty())
    val getBookState = _getBookState.asStateFlow()

    fun getBook(id: Int) {
        getBookUseCase.getBook(id).collectData(_getBookState)
    }
}