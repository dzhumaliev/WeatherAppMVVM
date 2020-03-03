package com.example.weatherapp.model.currentWeather

class CloudEntity {
    var all = 0

    override fun toString(): String {
        return StringBuilder("[").append(all).append("]").toString()
    }
}
