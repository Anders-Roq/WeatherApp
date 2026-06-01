package com.example.weatherapp.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.weatherapp.HomePage
import com.example.weatherapp.ListPage
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.MapPage

@Composable
fun MainNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = Route.Home,
        modifier = modifier
    ) {

        composable<Route.Home> {
            HomePage(
                modifier = modifier,
                viewModel = viewModel
            )
        }

        composable<Route.List> {
            ListPage(
                modifier = modifier,
                viewModel = viewModel
            )
        }

        composable<Route.Map> {
            MapPage(
                modifier = modifier,
                viewModel = viewModel
            )
        }
    }
}