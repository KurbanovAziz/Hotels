package com.example.kitepkana.data.mappers

import com.example.kitepkana.data.models.HotelsModel
import com.example.kitepkana.domain.entities.Hotels


fun Hotels.fromHotels() = HotelsModel(
    about_the_hotel, adress, id, image_urls, minimal_price, name, price_for_it, rating, rating_name
)

fun HotelsModel.toHotels() = Hotels(
    about_the_hotel, adress, id, image_urls, minimal_price, name, price_for_it, rating, rating_name
)

