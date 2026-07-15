package com.example.weatherapp.api

import com.example.weatherapp.model.Forecast

data class APIForecastDay(
    var date: String? = null, var day: APIWeather? = null
)
