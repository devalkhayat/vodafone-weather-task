package com.vodafone.features.city_chooser.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

class CityChooserApiImpl: CityChooserApi {
    override fun registerGraph(
        navController: NavHostController ,
        navGraphBuilder: NavGraphBuilder
    ) {
        InternalCityChooserFeatureApi.registerGraph(navController , navGraphBuilder)
    }

}