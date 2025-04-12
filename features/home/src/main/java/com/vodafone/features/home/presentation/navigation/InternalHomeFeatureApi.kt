package com.vodafone.features.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vodafone.core.navigation.CityChooserFeatureRoutes
import com.vodafone.core.navigation.HomeFeatureRoutes
import com.vodafone.core.navigation.NavigationApi
import com.vodafone.features.home.presentation.screens.HomeScreen

internal object InternalHomeFeatureApi: NavigationApi {
    override fun registerGraph(
        navController: NavHostController ,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation<HomeFeatureRoutes.Graph>(startDestination = HomeFeatureRoutes.HomeScreenRoute){
            composable<HomeFeatureRoutes.HomeScreenRoute>{
                HomeScreen(navController)
            }

        }
    }

}