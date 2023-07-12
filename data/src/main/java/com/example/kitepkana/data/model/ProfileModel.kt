package com.example.kitepkana.data.model

import com.example.kitepkana.domain.model.Books

data class ProfileModel(
    val email: String,
    val password: String,
    val user_photo: String,
    val username: String,
    val reading : List<Books>,
    val finish : List<Books>,
    val favorite : List<Books>,
)