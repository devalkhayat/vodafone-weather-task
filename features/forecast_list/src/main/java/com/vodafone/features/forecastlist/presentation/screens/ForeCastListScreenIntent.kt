package com.vodafone.features.forecastlist.presentation.screens

sealed interface ForeCastListScreenIntent{

    data object GetData:ForeCastListScreenIntent
}