package com.example.kitepkana.domain.model

data class Profile(
    val email: String,
    val password: String,
    val user_photo: String,
    val username: String,
    val reading : List<com.example.kitepkana.domain.model.Books>,
    val finish : List<com.example.kitepkana.domain.model.Books>,
    val favorite : List<com.example.kitepkana.domain.model.Books>,
)