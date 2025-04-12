package com.vodafone.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface NavigationApi {
    fun registerGraph(
        navController: NavHostController ,
        navGraphBuilder: NavGraphBuilder
    )
}