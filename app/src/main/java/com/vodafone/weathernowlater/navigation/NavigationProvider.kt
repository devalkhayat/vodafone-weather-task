package com.vodafone.weathernowlater.navigation

import com.vodafone.features.city_chooser.presentation.navigation.CityChooserApi
import com.vodafone.features.home.presentation.navigation.HomeApi

data class NavigationProvider(val cityChooser: CityChooserApi,val home: HomeApi)