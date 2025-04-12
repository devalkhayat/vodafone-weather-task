package com.vodafone.features.home.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.vodafone.core.components.AnimatedPreloader
import com.vodafone.core.components.LabelCity
import com.vodafone.core.components.LabelDegree
import com.vodafone.core.components.LabelStatus
import com.vodafone.core.components.Section
import com.vodafone.core.navigation.CityChooserFeatureRoutes
import com.vodafone.core.theme.colors
import com.vodafone.core.util.toDegree
import com.vodafone.features.forecastlist.presentation.screens.ForeCastListScreen
import com.vodafone.features.home.domain.model.CityWeatherInfoModel

import com.vodafone.weathericonslibrary.*


@Composable
fun HomeScreen(navHostController: NavHostController,homeScreenViewModel: HomeScreenViewModel= hiltViewModel()){

    LaunchedEffect(true) {
        homeScreenViewModel.getData()
    }
    val rs = homeScreenViewModel.savedData.value

    if(rs.isSuccess){
        MainSection(navHostController,rs.data!!)
    }


}


@Composable
fun MainSection(navHostController: NavHostController , model: CityWeatherInfoModel) {

    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.blue)){

        Column {

            Section(modifier = Modifier.height(225.dp)) {

                Column{

                    Row(modifier = Modifier.fillMaxWidth().padding(17.dp)) {

                        model.let {
                            Column(modifier = Modifier.weight(1f)) {


                                LabelDegree(it.cityDegree.toDegree())
                                Spacer(modifier = Modifier.height(16.dp))
                                LabelStatus(it.cityStatus)
                                Spacer(modifier = Modifier.height(16.dp))
                                City(navHostController,it.cityName)
                            }

                            Column(modifier = Modifier.weight(1f)){
                                AnimatedPreloader(icon = GetIcon(it.cityStatus))
                            }

                        }

                    }

                }







            }
            Spacer(modifier = Modifier.height(8.dp))
            ForeCastListScreen()
        }

    }


}

@Composable
fun City(navHostController:NavHostController,name:String){

    Box(
        modifier = Modifier

            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colors.blue).clickable {

                navHostController.navigate(CityChooserFeatureRoutes.ChooserScreenRoute)

            }
    ) {
        Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
            Image(painter = painterResource(com.vodafone.core.R.drawable.ic_current_location) , contentDescription = "location")
            Spacer(modifier = Modifier.width(8.dp))
            LabelCity(name)
        }
    }
}