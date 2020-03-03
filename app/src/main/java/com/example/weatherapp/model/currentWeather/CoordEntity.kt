package com.example.weatherapp.model.currentWeather

class CoordEntity {
    var lon = 0.0
    var lat = 0.0

    override fun toString(): String {
        return StringBuilder("[").append(lat).append(',').append(lon)
            .append("]").toString()
    }
}