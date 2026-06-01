package com.example.weatherapp

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.City

class MainViewModel : ViewModel() {

    private fun createInitialCities() = List(20) { i ->
        City(
            name = "Cidade $i",
            weather = "Carregando clima..."
        )
    }

    private val _cities = createInitialCities().toMutableStateList()

    val cities
        get() = _cities.toList()

    fun remove(city: City) {
        _cities.remove(city)
    }

    fun add(name: String) {
        _cities.add(City(name = name))
    }
}