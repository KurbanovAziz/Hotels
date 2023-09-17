package com.example.kitepkana.presentation.ui.fragments.authorization.register


import com.example.kitepkana.domain.entities.Registration
import com.example.kitepkana.domain.usecases.RegistrationUseCase
import com.example.kitepkana.presentation.base.BaseViewModel
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registrationUseCase: RegistrationUseCase
) : BaseViewModel() {


    private val _registrationUsersState = MutableStateFlow<UIState<Registration>>(UIState.Empty())
    val registrationUsersState = _registrationUsersState.asStateFlow()

    fun registrationUsers(registration: Registration) {
        registrationUseCase.registrationUsers(registration).collectData(_registrationUsersState)
    }

}