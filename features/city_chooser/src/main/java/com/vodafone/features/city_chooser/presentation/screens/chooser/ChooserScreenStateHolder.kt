package com.vodafone.features.city_chooser.presentation.screens.chooser

import com.vodafone.features.city_chooser.domain.model.WeatherInfoModel


data class ChooserScreenStateHolder(val isLoading:Boolean=false,val isSuccess:Boolean=false , val data: WeatherInfoModel?=null , val error:String="")

