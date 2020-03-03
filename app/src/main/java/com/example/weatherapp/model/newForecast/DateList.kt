package com.example.weatherapp.model.newForecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DateList(
    @SerializedName("moonrise_ts")
    @Expose
    var moonriseTs: Int? = null,
    @SerializedName("wind_cdir")
    @Expose
    val windCdir: String? = null,
    @SerializedName("rh")
    @Expose
    val rh: Int? = null,
    @SerializedName("pres")
    @Expose
    val pres: Double? = null,
    @SerializedName("high_temp")
    @Expose
    val highTemp: Double? = null,
    @SerializedName("sunset_ts")
    @Expose
    val sunsetTs: Int? = null,
    @SerializedName("ozone")
    @Expose
    val ozone: Double? = null,
    @SerializedName("moon_phase")
    @Expose
    val moonPhase: Double? = null,
    @SerializedName("wind_gust_spd")
    @Expose
    val windGustSpd: Double? = null,
    @SerializedName("snow_depth")
    @Expose
    val snowDepth: Double? = null,
    @SerializedName("clouds")
    @Expose
    val clouds: Int? = null,
    @SerializedName("ts")
    @Expose
    val ts: Int? = null,
    @SerializedName("sunrise_ts")
    @Expose
    val sunriseTs: Int? = null,
    @SerializedName("app_min_temp")
    @Expose
    val appMinTemp: Double? = null,
    @SerializedName("wind_spd")
    @Expose
    val windSpd: Double? = null,
    @SerializedName("pop")
    @Expose
    val pop: Int? = null,
    @SerializedName("wind_cdir_full")
    @Expose
    val windCdirFull: String? = null,
    @SerializedName("slp")
    @Expose
    val slp: Double? = null,
    @SerializedName("valid_date")
    @Expose
    val validDate: String? = null,
    @SerializedName("app_max_temp")
    @Expose
    val appMaxTemp: Double? = null,
    @SerializedName("vis")
    @Expose
    val vis: Double? = null,
    @SerializedName("dewpt")
    @Expose
    val dewpt: Double? = null,
    @SerializedName("snow")
    @Expose
    val snow: Double? = null,
    @SerializedName("uv")
    @Expose
    val uv: Double? = null,
    @SerializedName("weather")
    @Expose
    val weather: WeatherList? = null,
    @SerializedName("wind_dir")
    @Expose
    val windDir: Int? = null,
    @SerializedName("max_dhi")
    @Expose
    val maxDhi: Any? = null,
    @SerializedName("clouds_hi")
    @Expose
    val cloudsHi: Int? = null,
    @SerializedName("precip")
    @Expose
    val precip: Double? = null,
    @SerializedName("low_temp")
    @Expose
    val lowTemp: Double? = null,
    @SerializedName("max_temp")
    @Expose
    val maxTemp: Double? = null,
    @SerializedName("moonset_ts")
    @Expose
    val moonsetTs: Int? = null,
    @SerializedName("datetime")
    @Expose
    val datetime: String? = null,
    @SerializedName("temp")
    @Expose
    val temp: Double? = null,
    @SerializedName("min_temp")
    @Expose
    val minTemp: Double? = null,
    @SerializedName("clouds_mid")
    @Expose
    val cloudsMid: Int? = null,
    @SerializedName("clouds_low")
    @Expose
    val cloudsLow: Int? = null

)