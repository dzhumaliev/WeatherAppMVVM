package com.example.weatherapp.model.currentWeather

class MainEntity : CurrentWeatherEntity() {
    var temp = 0.0
    var temp_min = 0.0
    var humidity = 0
    var pressure = 0
    var temp_max = 0.0
    var feels_like = 0.0

    override fun toString(): String {
        return StringBuilder("[").append(temp).append(',').append(temp_min)
            .append(',').append(temp_max)
            .append(',').append(humidity).append(feels_like).append(pressure).append("]").toString()
    }
}
