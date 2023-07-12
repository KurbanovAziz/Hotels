package com.example.kitepkana.presentation.ui.fragments.search

import com.example.kitepkana.domain.model.Books
import com.example.kitepkana.domain.usecases.SearchFilterUseCase
import com.example.kitepkana.presentation.base.BaseViewModel
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchFilterUseCase: SearchFilterUseCase,
) : BaseViewModel() {

    private val _searchFilterState = MutableStateFlow<UIState<List<com.example.kitepkana.domain.model.Books>>>(UIState.Empty())
    val searchFilterState = _searchFilterState.asStateFlow()

    fun searchFilter(search: String) {
        searchFilterUseCase.searchFilter(search).collectData(_searchFilterState)
    }

}