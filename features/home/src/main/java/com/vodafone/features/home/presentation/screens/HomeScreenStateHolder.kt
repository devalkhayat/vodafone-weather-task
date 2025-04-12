package com.vodafone.features.home.presentation.screens

import com.vodafone.features.home.domain.model.CityWeatherInfoModel


data class HomeScreenStateHolder(val isLoading:Boolean=false,val isSuccess:Boolean=false , val data: CityWeatherInfoModel?=null , val error:String="")