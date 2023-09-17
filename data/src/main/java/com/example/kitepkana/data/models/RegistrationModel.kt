package com.example.kitepkana.data.models

import com.example.kitepkana.domain.entities.Users
import com.google.gson.annotations.SerializedName

data class RegistrationModel(
    val first_name : Users,
    val last_name : Users,
    val email : Users,
)
