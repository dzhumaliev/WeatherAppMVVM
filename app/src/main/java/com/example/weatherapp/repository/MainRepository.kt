package com.example.weatherapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.BuildConfig.WEATHER_FORECAST_KEY
import com.example.weatherapp.BuildConfig.WEATHER_KEY
import com.example.weatherapp.api.ForecastRetrofitBuilder
import com.example.weatherapp.api.RetrofitBuilder
import com.example.weatherapp.api.WeatherApi
import com.example.weatherapp.model.currentWeather.CurrentWeatherEntity
import com.example.weatherapp.model.newForecast.MainWeatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class MainRepository {

    companion object {

        private lateinit var currentApiService: WeatherApi
        private lateinit var forecastApiServiceBuilder: WeatherApi


        fun fetchWeatherData(cityName: String, lang: String): LiveData<CurrentWeatherEntity> {
            val data = MutableLiveData<CurrentWeatherEntity>()
            currentApiService = RetrofitBuilder().create()
            currentApiService.getCurrentWeather(cityName, lang, WEATHER_KEY, "metric")
                ?.enqueue(object :
                    Callback<CurrentWeatherEntity?> {
                    override fun onResponse(
                        call: Call<CurrentWeatherEntity?>,
                        response: Response<CurrentWeatherEntity?>
                    ) {
                        data.value = response.body()
                        Log.d("onResponse ", call.request().toString())
                    }

                    override fun onFailure(call: Call<CurrentWeatherEntity?>, t: Throwable) {
                        data.value = null
                        Log.d("onFailure ", call.request().toString())
                    }
                })
            return data
        }

        fun fetchForecastWeatherData(cityName: String): LiveData<MainWeatherModel> {
            val data = MutableLiveData<MainWeatherModel>()
            forecastApiServiceBuilder = ForecastRetrofitBuilder().create()
            forecastApiServiceBuilder.getForecastWeather(
                cityName,
                WEATHER_FORECAST_KEY
            )
                .enqueue(object : Callback<MainWeatherModel> {
                    override fun onResponse(
                        call: Call<MainWeatherModel>,
                        response: Response<MainWeatherModel>
                    ) {
                        if (response.body() != null) {
                            data.value = response.body()
                            Log.d("test ", call.request().toString())
                        }
                    }

                    override fun onFailure(call: Call<MainWeatherModel>, t: Throwable) {
                        Log.d("onFailure ", call.request().toString())
                    }
                })
            return data
        }
    }
}


