package com.example.hotel.data.mappers

import com.example.hotel.data.models.HotelsModel
import com.example.hotel.data.models.ReservationModel
import com.example.hotel.data.models.RoomsModel
import com.example.hotel.domain.entities.Hotels
import com.example.hotel.domain.entities.Reservation
import com.example.hotel.domain.entities.Rooms

fun HotelsModel.toHotels() = Hotels(
    about_the_hotel,
    adress,
    id,
    image_urls,
    minimal_price,
    name,
    price_for_it,
    rating,
    rating_name
)

fun RoomsModel.toRooms() = Rooms(
    rooms
)

fun ReservationModel.toReservation() = Reservation(
    arrival_country,
    departure,
    fuel_charge,
    horating,
    hotel_adress,
    hotel_name,
    id,
    number_of_nights,
    nutrition,
    rating_name,
    room,
    service_charge,
    tour_date_start,
    tour_date_stop,
    tour_price
)

