package com.and.flightbooking.Domain

import java.io.Serializable

data class FlightModel(
    var AirLineLogo: String="",
    var AirLineName: String="",
    var AirLineTime: String="",
    var ClassSeat: String="",
    var Date: String="",
    var From: String="",
    var FromShort: String="",
    var NumerSeat: String="",
    var Price: String="",
    var Passenger: String="",
    var Seats: String="",
    var ReservedSeats: String="",
    var Time: String="",
    var To: String="",
    var ToShort: String=""
): Serializable
