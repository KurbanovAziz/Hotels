package com.example.kitepkana.presentation.ui.fragments.book.open

import com.example.kitepkana.domain.model.ResultD
import com.example.kitepkana.domain.usecases.*
import com.example.kitepkana.presentation.base.BaseViewModel
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ReadBookViewModel @Inject constructor(
    private val getReadBookUseCase: GetReadBookUseCase,
) : BaseViewModel() {


    private val _getReadBookState = MutableStateFlow<UIState<com.example.kitepkana.domain.model.ResultD>>(UIState.Empty())
    val getReadBookState = _getReadBookState.asStateFlow()

    fun getReadBook(id: Int,page : Int) {
        getReadBookUseCase.getReadBook(id,page).collectData(_getReadBookState)
    }

}