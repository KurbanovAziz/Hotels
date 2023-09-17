package com.example.kitepkana.data.mappers

import com.example.kitepkana.data.models.RegistrationModel
import com.example.kitepkana.domain.entities.Registration


fun Registration.fromRegistration() = RegistrationModel(
    first_name, last_name, email
)

fun RegistrationModel.toRegistration() = Registration(
   first_name, last_name, email
)

