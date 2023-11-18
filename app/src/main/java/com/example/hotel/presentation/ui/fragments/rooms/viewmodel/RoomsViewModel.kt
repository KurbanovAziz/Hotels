package com.example.hotel.presentation.ui.fragments.rooms.viewmodel

import com.example.hotel.domain.entities.Rooms
import com.example.hotel.domain.usecases.GetRoomsUseCase
import com.example.hotel.presentation.base.BaseViewModel
import com.example.hotel.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val getRoomsUseCase: GetRoomsUseCase,
) : BaseViewModel() {

    private val _getRoomsState = MutableStateFlow<UIState<Rooms>>(UIState.Empty())
    val getRoomsState = _getRoomsState.asStateFlow()

    fun getRooms() {
        getRoomsUseCase.getRooms().collectData(_getRoomsState)
    }
}