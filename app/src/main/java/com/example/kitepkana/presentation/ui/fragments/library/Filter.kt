package com.example.kitepkana.presentation.ui.fragments.library

import com.example.kitepkana.domain.model.Books

data class Filter(
    val id: Int? = null,
    val title: String? = null,
    val books: List<com.example.kitepkana.domain.model.Books>? = null
)