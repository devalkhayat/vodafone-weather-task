package com.vodafone.features.city_chooser.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vodafone.core.navigation.CityChooserFeatureRoutes
import com.vodafone.core.navigation.NavigationApi
import com.vodafone.features.city_chooser.presentation.screens.chooser.ChooserScreen

internal object InternalCityChooserFeatureApi: NavigationApi {
    override fun registerGraph(
        navController: NavHostController ,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<CityChooserFeatureRoutes.Graph>(startDestination = CityChooserFeatureRoutes.ChooserScreenRoute){
            composable<CityChooserFeatureRoutes.ChooserScreenRoute>{
                ChooserScreen(navController)
            }

        }
    }

}