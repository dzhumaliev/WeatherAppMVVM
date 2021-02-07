package com.example.weatherapp.ui.forecastMain

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.newForecast.MainWeatherModel
import com.example.weatherapp.repository.MainRepository

class ForecastViewModel : ViewModel() {

    fun getForecastWeatherData(cityText: String,lang: String): LiveData<MainWeatherModel> {
        return MainRepository.fetchForecastWeatherData(cityText, lang)
    }

}