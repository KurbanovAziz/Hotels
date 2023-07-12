package com.example.kitepkana.domain.model

data class Favorites(
    val id: Int,
    val title: String,
    val cover: String,
    val author_name: String,
    val summary: String,
    val middle_star: Double,
)