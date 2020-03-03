package com.example.weatherapp.model.newForecast

import com.google.gson.annotations.SerializedName

data class MainWeatherModel(
    @SerializedName("data")
    var list: List<DateList>,
    @SerializedName("city_name")
    val cityName: String? = null,
    @SerializedName("lon")
    val lon: Double? = null,
    @SerializedName("timezone")
    val timezone: String? = null,
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("country_code")
    val countryCode: String? = null,
    @SerializedName("state_code")
    val stateCode: String? = null
)