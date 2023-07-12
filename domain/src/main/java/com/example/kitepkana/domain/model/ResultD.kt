package com.example.kitepkana.domain.model


data class ResultD(
    val count : Int,
    val results : List<com.example.kitepkana.domain.model.ResultD2>
)

data class ResultD2(
    val text: String,
    val id: Int
)