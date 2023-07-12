package com.example.kitepkana.domain.model

data class DetailBook(
    val author_name: String,
    val cover: String,
    val genre: List<com.example.kitepkana.domain.model.Genre>,
    val id: Int,
    val middle_star: Double,
    val publication_year: String,
    val reviews : List<com.example.kitepkana.domain.model.Reviews>,
    val summary: String,
    val title: String,
    val similar_books : List<com.example.kitepkana.domain.model.Books>
)

data class Genre(
    val genre_name: String,
    val id: Int
)

data class Reviews(
    val username: String,
    val id: Int,
    val text: String,
    val user_stars: String,
    val user_photo: String,
    val created_date: String,
    val updated_date: String
)

