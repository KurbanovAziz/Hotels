package com.example.kitepkana.presentation.ui.fragments.authorization.auth

import com.example.kitepkana.domain.model.authorization.CreateJwtToken
import com.example.kitepkana.domain.model.authorization.JwtToken
import com.example.kitepkana.domain.usecases.authorization.CreateJwtTokenUseCase
import com.example.kitepkana.presentation.base.BaseViewModel
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val createJwtTokenUseCase: CreateJwtTokenUseCase,
) : BaseViewModel() {

    private val _createJwtTokenState = MutableStateFlow<UIState<JwtToken>>(UIState.Empty())
    val createJwtTokenState = _createJwtTokenState.asStateFlow()

    fun getJwt(
        createJwtToken: CreateJwtToken
    ) {
        createJwtTokenUseCase.createJwtToken(createJwtToken)
            .collectData(_createJwtTokenState)
    }
}
