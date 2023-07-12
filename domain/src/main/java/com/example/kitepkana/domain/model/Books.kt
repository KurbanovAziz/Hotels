package com.example.kitepkana.domain.model

data class Books(
    val id: Int = 0,
    val title: String,
    val cover: String,
    val author_name: String,
    val summary : String,
    val middle_star: Double,
)