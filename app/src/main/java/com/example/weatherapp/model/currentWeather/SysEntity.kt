package com.example.weatherapp.model.currentWeather

class SysEntity {
    var country: String? = null
    var sunrise: Long = 0
    var sunset: Long = 0
    var id = 0
    var type = 0
    var message = 0.0

    override fun toString(): String {
        return StringBuilder("[").append(country).append(',').append(sunrise)
            .append(',').append(sunset)
            .append(',').append(id).append(type).append(message).append("]")
            .toString()
    }
}

