package com.example.weatherapp.api

import com.example.weatherapp.model.currentWeather.CurrentWeatherEntity
import com.example.weatherapp.model.newForecast.MainWeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    fun getCurrentWeather(
        @Query("q") city: String?,
        @Query("lang") lang: String,
        @Query("appid") appId: String?,
        @Query("units") metric: String?
    ): Call<CurrentWeatherEntity?>?

    @GET("forecast/daily")
    fun getForecastWeather(
        @Query("city") cityApi: String,
        @Query("lang") lang: String,
        @Query("key") keyApi: String
    ): Call<MainWeatherModel>
}

