package com.vodafone.weathernowlater.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.vodafone.core.navigation.CityChooserFeatureRoutes

@Composable
fun AppNavGraph(navController: NavHostController , navigationProvider: NavigationProvider,startFeature:Any){

    NavHost(navController = navController, startDestination = startFeature ){
        navigationProvider.cityChooser.registerGraph(navController,this)
        navigationProvider.home.registerGraph(navController,this)

    }

}