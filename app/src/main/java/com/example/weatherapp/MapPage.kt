package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@SuppressLint("UnrememberedMutableState")
@Composable
fun MapPage(modifier: Modifier = Modifier, viewModel: MainViewModel) {

    val camPosState = rememberCameraPositionState ()

    val recife = remember { MarkerState(LatLng(-8.05, -34.9)) }
    val caruaru = remember { MarkerState( LatLng(-8.27, -35.98)) }
    val joaopessoa = remember { MarkerState(LatLng(-7.12, -34.84)) }

    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = camPosState,
        onMapClick = {
            viewModel.add(
                "Cidade@${it.latitude}:${it.longitude}",
                    location = it
            )
        }
    ) {

        viewModel.cities.forEach { city ->
            if (city.location != null) {
                Marker(
                    state = MarkerState(position = city.location),
                    title = city.name,
                    snippet = city.location.toString()
                )
            }
        }
        Marker(
            state = recife,
            title = "Recife",
            snippet = "Marcador em Recife",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
        )
        Marker(
            state = caruaru,
            title = "Caruaru",
            snippet = "Marcador em Caruaru",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)
        )
        Marker(
            state = joaopessoa,
            title = "João Pessoa",
            snippet = "Marcador em João Pessoa",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)
        )
    }
}