package com.example.kitepkana.presentation.ui.fragments.book

import com.example.kitepkana.domain.model.AddFavorite
import com.example.kitepkana.domain.model.CreateReviews
import com.example.kitepkana.domain.model.DetailBook
import com.example.kitepkana.domain.usecases.AddFavoritesUseCase
import com.example.kitepkana.domain.usecases.CreateReviewsUseCase
import com.example.kitepkana.domain.usecases.DeleteFavoritesUseCase
import com.example.kitepkana.domain.usecases.GetBookUseCase
import com.example.kitepkana.presentation.base.BaseViewModel
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val getBookUseCase: GetBookUseCase,
    private val addFavoritesUseCase: AddFavoritesUseCase,
    private val deleteFavoritesUseCase: DeleteFavoritesUseCase,
    private val createReviewsUseCase: CreateReviewsUseCase
) : BaseViewModel() {


    private val _getBookState = MutableStateFlow<UIState<com.example.kitepkana.domain.model.DetailBook>>(UIState.Empty())
    val getBookState = _getBookState.asStateFlow()

    fun getBook(id: Int) {
        getBookUseCase.getBook(id).collectData(_getBookState)
    }

    private val _addFavoriteState = MutableStateFlow<UIState<com.example.kitepkana.domain.model.AddFavorite>>(UIState.Empty())
    val addFavoriteState = _addFavoriteState.asStateFlow()

    fun addFavorite(addFavorite: com.example.kitepkana.domain.model.AddFavorite) {
        addFavoritesUseCase.addFavorite(addFavorite).collectData(_addFavoriteState)
    }

    private val _deleteFavoriteState = MutableStateFlow<UIState<Int>>(UIState.Empty())
    val deleteFavoriteState = _deleteFavoriteState.asStateFlow()

    fun deleteFavorite(id: Int) {
        deleteFavoritesUseCase.deleteFavorite(id).collectData(_deleteFavoriteState)
    }

    private val _createReviewsState = MutableStateFlow<UIState<com.example.kitepkana.domain.model.CreateReviews>>(UIState.Empty())
    val createReviewsState = _createReviewsState.asStateFlow()

    fun createReviews(createReviews: com.example.kitepkana.domain.model.CreateReviews) {
        createReviewsUseCase.createReviews(createReviews).collectData(_createReviewsState)
    }
}