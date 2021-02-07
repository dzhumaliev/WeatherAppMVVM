package com.example.weatherapp.ui.forecastMain.forecastAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.model.newForecast.DateList


class ForecastAdapter : RecyclerView.Adapter<ForecastViewHolder>() {

    private var weather: List<DateList> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_forecast_weather, parent, false)
        return ForecastViewHolder(view)

    }

    fun update(weather: List<DateList>) {
        this.weather = weather
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(weather[position])
    }

    override fun getItemCount(): Int {
        return weather.size
    }


}
