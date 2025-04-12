package com.vodafone.weathernowlater

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vodafone.core.theme.WeatherNowLaterTheme
import com.vodafone.features.home.presentation.screens.HomeScreenViewModel
import com.vodafone.weathernowlater.navigation.AppNavGraph
import com.vodafone.weathernowlater.navigation.NavigationProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.hilt.navigation.compose.hiltViewModel
import com.vodafone.core.navigation.CityChooserFeatureRoutes
import com.vodafone.core.navigation.HomeFeatureRoutes

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherNowLaterTheme {
                val navController= rememberNavController()
                val viewModel:HomeScreenViewModel = hiltViewModel()
                val rs = viewModel.savedData.value

                LaunchedEffect(true) {
                    viewModel.getData()
                }

                Main {
                    if(!rs.isLoading){

                        if(rs.isSuccess){

                            AppNavGraph(
                                navController = navController ,
                                navigationProvider = navigationProvider ,
                                startFeature = if (rs.data == null) CityChooserFeatureRoutes.Graph else HomeFeatureRoutes.Graph
                            )

                        }else{

                            AppNavGraph(
                                navController = navController ,
                                navigationProvider = navigationProvider ,
                                startFeature =  CityChooserFeatureRoutes.Graph
                            )
                        }

                    }


                }

            }
        }
    }
}

@Composable
fun Main(content: @Composable ()->Unit){
    Scaffold(modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
           content()
        }
    }
}
