package com.vodafone.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class CityChooserFeatureRoutes{
    @Serializable
    data object Graph:CityChooserFeatureRoutes()
    @Serializable
    data object ChooserScreenRoute:CityChooserFeatureRoutes()

}

@Serializable
sealed class HomeFeatureRoutes{
    @Serializable
    data object Graph:HomeFeatureRoutes()
    @Serializable
    data object HomeScreenRoute:HomeFeatureRoutes()

}

