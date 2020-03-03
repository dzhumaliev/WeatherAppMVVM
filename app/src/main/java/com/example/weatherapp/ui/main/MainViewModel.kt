package com.example.weatherapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.repository.MainRepository
import com.example.weatherapp.model.currentWeather.CurrentWeatherEntity

class MainViewModel : ViewModel(){

    fun getWeatherData(cityName : String, lang: String) : LiveData<CurrentWeatherEntity> {
        return MainRepository.fetchWeatherData(cityName, lang)
    }
}