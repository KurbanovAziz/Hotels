package com.example.kitepkana.presentation.ui.fragments.tours.viewmodel

import com.example.kitepkana.domain.entities.Hotels
import com.example.kitepkana.domain.usecases.GetHotelsUseCase
import com.example.kitepkana.presentation.base.BaseViewModel
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HotelsViewModel @Inject constructor(
    private val getHotelsUseCase: GetHotelsUseCase,
) : BaseViewModel() {

    private val _getHotelsState = MutableStateFlow<UIState<Hotels>>(UIState.Empty())
    val getHotelsState = _getHotelsState.asStateFlow()

    fun getHotels() {
        getHotelsUseCase.getHotels().collectData(_getHotelsState)
    }

}