package com.example.hotel.presentation.ui.fragments.reservations.viewmodel

import android.text.Editable
import android.text.TextWatcher
import com.example.hotel.domain.entities.Reservation
import com.example.hotel.domain.usecases.GetReservationUseCase
import com.example.hotel.presentation.base.BaseViewModel
import com.example.hotel.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class ReservationViewModel @Inject constructor(
    private val getReservationUseCase: GetReservationUseCase,
) : BaseViewModel() {

    private val _getReservationState = MutableStateFlow<UIState<Reservation>>(UIState.Empty())
    val getReservationState = _getReservationState.asStateFlow()

    fun getReservation() {
        getReservationUseCase.getReservation().collectData(_getReservationState)
    }
}