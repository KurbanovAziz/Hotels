package com.example.kitepkana.data.mappers

import com.example.kitepkana.data.model.*
import com.example.kitepkana.domain.model.*


fun BooksModel.toBooks() = Books(
    id, title, cover, author_name, summary, middle_star
)

fun DetailBookModel.toDetailBook() = DetailBook(
    author_name,
    cover,
    genre,
    id,
    middle_star,
    publication_year,
    reviews,
    summary,
    title,
    similar_books
)

fun ResultModel.toReadBook() = ResultD(
    count,results
)

fun AddFavorite.fromFavorite() = AddFavoriteModel(
    book
)

fun AddFavoriteModel.toFavorite() = AddFavorite(
    book
)

fun CreateReviews.fromReviews() = CreateReviewsModel(
    book, star, text
)

fun CreateReviewsModel.toReviews() = CreateReviews(
    book, star, text
)


fun ProfileModel.toProfile() = Profile(
    email, password, user_photo, username,reading, finish, favorite
)
