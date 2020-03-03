package com.example.weatherapp.api

import com.example.weatherapp.BuildConfig.BASE_URL_WEATHER_FORECAST
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ForecastRetrofitBuilder {

    fun create(): WeatherApi {
        val okHttpClients = OkHttpClient().newBuilder()
            .connectTimeout(50, TimeUnit.SECONDS)
            .readTimeout(50, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
            .build()

        val retrofits = Retrofit.Builder()
            .baseUrl(BASE_URL_WEATHER_FORECAST)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClients)
            .build()

        return retrofits.create(WeatherApi::class.java)
    }
}

