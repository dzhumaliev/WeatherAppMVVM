package com.example.weatherapp.model.newForecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherList(
    @SerializedName("icon")
    @Expose
    var icon: String? = null,
    @SerializedName("code")
    @Expose
    val code: Int? = null,
    @SerializedName("description")
    @Expose
    val description: String? = null
)