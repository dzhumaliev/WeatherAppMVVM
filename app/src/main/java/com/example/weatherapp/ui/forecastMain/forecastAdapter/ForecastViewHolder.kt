package com.example.weatherapp.ui.forecastMain.forecastAdapter

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.weatherapp.R
import com.example.weatherapp.model.newForecast.DateList
import java.text.SimpleDateFormat
import kotlin.math.roundToInt


class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var description: TextView = itemView.findViewById(R.id.tv_desc_forecast)
    private var forecastImage: LottieAnimationView = itemView.findViewById(R.id.forecast_image)
    private var forecastTemp: TextView = itemView.findViewById(R.id.temp_forecast)
    private var forecastTime: TextView = itemView.findViewById(R.id.day)


    @SuppressLint("SetTextI18n")
    fun bind(list: DateList) {

        description.text = list.weather!!.description
        val celc = list.temp?.roundToInt()
        forecastTemp.text = celc.toString() + "º"
        forecastTime.text = list.datetime.toString()
        animationChanger(list)


    }

    private fun animationChanger(list: DateList) {

        val way: Int? = list.weather!!.code

        if (way in 200..202) {
            forecastImage.setAnimation(R.raw.stormshowersday)
        }
        if (way in 210..232) {
            forecastImage.setAnimation(R.raw.thunder)
        }
        if (way in 300..321) {
            forecastImage.setAnimation(R.raw.snow_sunny)
        }
        if (way in 500..531) {
            forecastImage.setAnimation(R.raw.shower)
        }
        if (way in 600..622) {

            forecastImage.setAnimation(R.raw.snow)
        }

        if (way == 700) {
            forecastImage.setAnimation(R.raw.mist)
        }
        if (way in 701..781) {
            forecastImage.setAnimation(R.raw.foggy)
        }
        if (way == 800) {
            forecastImage.setAnimation(R.raw.sunny)
        }
        if (way in 801..804) {
            forecastImage.setAnimation(R.raw.cloudy)
        }

        if (way == 900) {
            forecastImage.setAnimation(R.raw.storm)
        }
    }


}

