package com.example.kitepkana.presentation.ui.fragments.authorization.register.activation

import com.example.kitepkana.data.model.authorization.ResendActivationAccountModel
import com.example.kitepkana.domain.model.authorization.*
import com.example.kitepkana.domain.usecases.authorization.ActivationAccountUseCase
import com.example.kitepkana.domain.usecases.authorization.RegisterUsersUseCase
import com.example.kitepkana.domain.usecases.authorization.ResendActivationAccountUseCase
import com.example.kitepkana.presentation.base.BaseViewModel
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ActivationViewModel @Inject constructor(
    private val activationAccountUseCase: ActivationAccountUseCase,
    private val resendActivationAccountUseCase: ResendActivationAccountUseCase,
) : BaseViewModel() {


    private val _getRegisterActivationState =
        MutableStateFlow<UIState<ActivationAccountRes>>(UIState.Empty())
    val getRegisterActivation = _getRegisterActivationState.asStateFlow()


    fun activationAccount(activationAccount: ActivationAccount) {
        activationAccountUseCase.getActivation(activationAccount)
            .collectData(_getRegisterActivationState)
    }

    private val _getRegisterResendActivationState =
        MutableStateFlow<UIState<ResendActivationAccount>>(UIState.Empty())
    val getRegisterResendActivation = _getRegisterResendActivationState.asStateFlow()


    fun resendActivationAccount(resendActivationAccount: ResendActivationAccount) {
        resendActivationAccountUseCase.getResendActivation(resendActivationAccount)
            .collectData(_getRegisterResendActivationState)
    }
}
