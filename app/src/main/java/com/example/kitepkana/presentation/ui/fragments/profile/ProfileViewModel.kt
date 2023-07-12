package com.example.kitepkana.presentation.ui.fragments.profile

import com.example.kitepkana.domain.model.Favorites
import com.example.kitepkana.domain.model.Profile
import com.example.kitepkana.domain.usecases.GetFavoritesUseCase
import com.example.kitepkana.domain.usecases.GetProfileUseCase
import com.example.kitepkana.presentation.base.BaseViewModel
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
) : BaseViewModel() {

    private val _getProfileState = MutableStateFlow<UIState<com.example.kitepkana.domain.model.Profile>>(UIState.Empty())
    val getProfileState = _getProfileState.asStateFlow()

    fun getProfile() {
        getProfileUseCase.getProfile()
            .collectData(_getProfileState)
    }
}
