package com.example.weatherapp.ui.forecastMain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.model.newForecast.MainWeatherModel
import com.example.weatherapp.ui.forecastMain.forecastAdapter.ForecastAdapter
import shivam.developer.featuredrecyclerview.FeatureLinearLayoutManager
import shivam.developer.featuredrecyclerview.FeaturedRecyclerView


class ForecastActivity : AppCompatActivity() {

    private var adapter: ForecastAdapter? = null
    private var viewModel: ForecastViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        viewModel = ViewModelProviders.of(this).get(ForecastViewModel::class.java)

        val recyclerView =
            findViewById<RecyclerView>(R.id.featured_recycler_view) as FeaturedRecyclerView
        adapter = ForecastAdapter()
        val layoutManager = FeatureLinearLayoutManager(this, FeatureLinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        fetchForecastWeather()
    }

    private fun fetchForecastWeather() {
        val city = intent.getStringExtra("city")
        val lang = intent.getStringExtra("lang")
        val forecastData = viewModel?.getForecastWeatherData(city.toString(),lang)
        forecastData?.observe(this, androidx.lifecycle.Observer<MainWeatherModel> {
            val model: MainWeatherModel? = forecastData.value
            when {
                model != null -> {
                    getForecastData(model)
                }
            }
        })
    }

    private fun getForecastData(wea: MainWeatherModel?) {
        adapter?.update(wea!!.list)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
