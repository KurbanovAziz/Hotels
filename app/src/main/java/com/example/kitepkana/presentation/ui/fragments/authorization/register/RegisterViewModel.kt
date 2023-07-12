package com.example.kitepkana.presentation.ui.fragments.authorization.register

import com.example.kitepkana.domain.model.authorization.RegisterUsers
import com.example.kitepkana.domain.model.authorization.Users
import com.example.kitepkana.domain.usecases.authorization.RegisterUsersUseCase
import com.example.kitepkana.presentation.base.BaseViewModel
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUsersUseCase: RegisterUsersUseCase,
) : BaseViewModel() {

    private val _registerUsersState = MutableStateFlow<UIState<com.example.kitepkana.domain.model.authorization.Users>>(UIState.Empty())
    val registerUsersState = _registerUsersState.asStateFlow()


    fun registerUsers(
        registerUsers: com.example.kitepkana.domain.model.authorization.RegisterUsers
    ) {
        registerUsersUseCase.registerUsers(registerUsers)
            .collectData(_registerUsersState)
    }

}
