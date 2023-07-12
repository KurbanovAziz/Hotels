package com.example.kitepkana.data.model

import com.example.kitepkana.domain.model.Books
import com.example.kitepkana.domain.model.Genre
import com.example.kitepkana.domain.model.Reviews

data class DetailBookModel(
    val author_name: String,
    val cover: String,
    val genre: List<Genre>,
    val id: Int,
    val middle_star: Double,
    val publication_year: String,
    val reviews : List<Reviews>,
    val summary: String,
    val title: String,
    val similar_books : List<Books>
)


