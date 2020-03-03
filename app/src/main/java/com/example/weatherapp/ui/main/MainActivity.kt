package com.example.weatherapp.ui.main

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.weatherapp.R
import com.example.weatherapp.model.currentWeather.CurrentWeatherEntity
import com.example.weatherapp.ui.forecastMain.ForecastActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.String
import java.util.*
import kotlin.math.roundToInt


open class MainActivity : AppCompatActivity() {

    private var viewModel: MainViewModel? = null
    lateinit var animFadeIn: Animation
    val languages = arrayOf("Eng", "Ru", "Kgz")
    val engLang = "Eng"
    val ruLang = "Ru"
    val kgLang = "Kgz"
    var currLang: kotlin.String = "Eng"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        search_btn.setOnClickListener {
            fetchWeather()
        }

        if (spinner_tv != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            spinner_tv.adapter = adapter
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner_tv.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    Toast.makeText(
                            this@MainActivity,
                    "" + languages[position], Toast.LENGTH_SHORT
                    ).show()

                    currLang = languages[position]

                    if (currLang == "Eng"){
                        lang_image.setImageResource(R.drawable.eng)
                    }
                    if (currLang == "Ru"){
                        lang_image.setImageResource(R.drawable.rus)
                    }
                    if (currLang == "Kgz"){

                        lang_image.setImageResource(R.drawable.kg)
                    }
                }
            }
        }
        btnClickToForecast()


    }

    private fun fetchWeather() {
        val data = viewModel?.getWeatherData(city.text.toString(), currLang)
        data?.observe(this, androidx.lifecycle.Observer<CurrentWeatherEntity> {
            val model: CurrentWeatherEntity? = data.value
            when {
                model != null -> {
                    getData(model)
                }
            }
        })
    }

    private fun btnClickToForecast() {
        btn_forecast.setOnClickListener {
            val intent = Intent(this@MainActivity, ForecastActivity::class.java)
            intent.putExtra("city", city.text.toString())
            intent.putExtra("lang", languages)
            val sharedView: View = btn_forecast
            val transitionName = getString(R.string.btn_forecast_text)
            val transitionActivityOptions =
                ActivityOptions.makeSceneTransitionAnimation(
                    this@MainActivity,
                    sharedView,
                    transitionName
                )
            startActivity(intent, transitionActivityOptions.toBundle())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getData(data: CurrentWeatherEntity?) {

        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.anim)
        val temp = data?.main!!.temp.roundToInt()
        textCelsius.text = temp.toString() + "º"
        val tempMin = data.main?.temp_min?.roundToInt()
        tv_temp_min.text = tempMin.toString() + "º"
        val tempMax = data.main?.temp_max?.roundToInt()
        tv_temp_max.text = tempMax.toString() + "º"
        textDesc.text = String.valueOf(data.weather?.get(0)?.description)
        tv_wind.text = String.valueOf(data.wind?.speed) + " m/s"
        tv_humidity.text = String.valueOf(data.main?.humidity) + " %"
        tv_pressure.text = String.valueOf(data.main?.pressure) + " hPa"
        textDesc.text = textDesc.text.substring(
            0,
            1
        ).toUpperCase(Locale.getDefault()) + textDesc.text.substring(1)



        animSet()
        setAnim(data)
    }

    private fun animSet() {
        textCelsius.startAnimation(animFadeIn)
        textDesc.startAnimation(animFadeIn)
        tv_temp_min.startAnimation(animFadeIn)
        tv_temp_max.startAnimation(animFadeIn)
    }

    private fun setAnim(data: CurrentWeatherEntity?) {
        val animFadeInUnit: Unit? = imageView.startAnimation(animFadeIn)
        val way: Int? = data?.weather?.get(0)?.id
        val imageId: kotlin.String = data?.weather?.get(0)?.icon.toString()
        if (way in 200..202) {
            if (imageId == "11d") {
                imageView.setAnimation(R.raw.stormshowersday)
                animFadeInUnit
            } else {
                imageView.setAnimation(R.raw.storm)
                animFadeInUnit
            }
        }
        if (way in 210..232) {
            imageView.setAnimation(R.raw.thunder)
            animFadeInUnit
        }
        if (way in 300..321) {
            imageView.setAnimation(R.raw.snow_sunny)
            animFadeInUnit
        }
        if (way in 500..531) {
            if (imageId == "09d") {
                imageView.setAnimation(R.raw.shower)
                animFadeInUnit
            } else {
                imageView.setAnimation(R.raw.rainynight)
                animFadeInUnit
            }
        }
        if (way in 600..622) {
            if (imageId == "13d") {
                imageView.setAnimation(R.raw.snow)
                animFadeInUnit
            } else {
                imageView.setAnimation(R.raw.snownight)
                animFadeInUnit
            }
        }
        if (way in 701..781) {
            if (imageId == "50d") {
                imageView.setAnimation(R.raw.foggy)
                animFadeInUnit
            } else {
                imageView.setAnimation(R.raw.mist)
                animFadeInUnit
            }
        }
        if (way == 800) {
            if (imageId == "01d") {
                imageView.setAnimation(R.raw.sunny)
                animFadeInUnit
            } else {
                imageView.setAnimation(R.raw.night)
                animFadeInUnit
            }
        }
        if (way in 801..804) {
            when (imageId) {
                "02d" -> {
                    imageView.setAnimation(R.raw.cloudy)
                    animFadeInUnit
                }
                "02n" -> {
                    imageView.setAnimation(R.raw.cloudynight)
                    animFadeInUnit
                }
                "03d" -> {
                    imageView.setAnimation(R.raw.cloudy)
                    animFadeInUnit
                }
                "03n" -> {
                    imageView.setAnimation(R.raw.cloudynight)
                    animFadeInUnit
                }
                "04d" -> {
                    imageView.setAnimation(R.raw.cloudy)
                    animFadeInUnit
                }
                "04n" -> {
                    imageView.setAnimation(R.raw.cloudynight)
                    animFadeInUnit
                }
            }
        }
    }


}
