package com.example.kitepkana.presentation.ui.fragments.tours.viewmodel

import com.example.kitepkana.domain.usecases.RegistrationUseCase
import com.example.kitepkana.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HotelsViewModel @Inject constructor(
    private val registrationUseCase: RegistrationUseCase,
) : BaseViewModel() {


}