package com.vodafone.features.forecastlist.presentation.screens

import com.vodafone.features.forecastlist.domain.model.LocalFutureWeatherModel

data class ForeCastListScreenStateHolder(val isLoading:Boolean=false,val isSuccess:Boolean=false , val data: List<LocalFutureWeatherModel>?=null , val error:String="")