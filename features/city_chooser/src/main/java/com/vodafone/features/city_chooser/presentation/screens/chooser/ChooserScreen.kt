package com.vodafone.features.city_chooser.presentation.screens.chooser

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.vodafone.core.components.AnimatedPreloader
import com.vodafone.core.components.AppButton
import com.vodafone.core.components.CitiesDropDown
import com.vodafone.core.components.City
import com.vodafone.core.components.LabelFormHeader
import com.vodafone.core.components.LabelHeader
import com.vodafone.core.components.Section
import com.vodafone.core.navigation.HomeFeatureRoutes
import com.vodafone.core.theme.colors
import com.vodafone.features.city_chooser.R
import kotlinx.coroutines.launch

@Composable
fun ChooserScreen(navHostController: NavHostController , chooserScreenViewModel: ChooserScreenViewModel= hiltViewModel()){

    val coroutine= rememberCoroutineScope()
    var selectedCity by remember { mutableStateOf<City?>(City.Cairo) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.blue), contentAlignment = Alignment.Center){

        Column {

            AnimatedPreloader(modifier = Modifier.height(150.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Section(modifier = Modifier.height(250.dp)) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp), verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally) {
                    LabelFormHeader(caption = stringResource(com.vodafone.core.R.string.choose_city))
                    CitiesDropDown() {
                        selectedCity=it
                    }
                    AppButton(stringResource(com.vodafone.core.R.string.show)){
                        coroutine.launch {
                            selectedCity?.let {
                                chooserScreenViewModel.getWeatherInfo(it.latitude,it.longitude)
                            }

                        }


                    }
                }


            }

            val weatherResult= chooserScreenViewModel.weatherInfo.value

            if(weatherResult.isSuccess){
                LaunchedEffect(true) {
                    chooserScreenViewModel.saveToLocal(selectedCity?.name!!)
                }
            }


            val storeStatus=chooserScreenViewModel.localOperations.value

            if(storeStatus.isSuccess){

                navHostController.navigate(HomeFeatureRoutes.HomeScreenRoute){
                    popUpTo(HomeFeatureRoutes.HomeScreenRoute){inclusive=true}
                }

            }

        }

    }


}