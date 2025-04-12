package com.vodafone.features.city_chooser.presentation.screens.chooser

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vodafone.core.util.UiEvent
import com.vodafone.features.city_chooser.domain.model.CityInfoModel
import com.vodafone.features.city_chooser.domain.model.LocalWeatherInfoModel
import com.vodafone.features.city_chooser.domain.model.RecordModel
import com.vodafone.features.city_chooser.domain.use_cases.AddCityInfoToLocalUseCase
import com.vodafone.features.city_chooser.domain.use_cases.GetCurrentWeatherInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChooserScreenViewModel @Inject constructor(private val getCurrentWeatherInfoUseCase: GetCurrentWeatherInfoUseCase,private val addCityInfoToLocalUseCase: AddCityInfoToLocalUseCase):ViewModel() {

    private val _weatherInfo= mutableStateOf(ChooserScreenStateHolder())
    val weatherInfo: State<ChooserScreenStateHolder> get()=_weatherInfo

    private val _localOperations= mutableStateOf(ChooserScreenStateHolder())
    val localOperations: State<ChooserScreenStateHolder> get()=_localOperations


    fun getWeatherInfo(latitude:String,longitude:String){
        viewModelScope.launch {

            getCurrentWeatherInfoUseCase(latitude, longitude,"metric").onEach {
                when(it){
                    is UiEvent.Loading -> _weatherInfo.value= ChooserScreenStateHolder(isLoading = true)
                    is UiEvent.Success -> _weatherInfo.value= ChooserScreenStateHolder(isSuccess = true,data=it.data)
                    is UiEvent.Error -> _weatherInfo.value= ChooserScreenStateHolder(error = it.message.toString())
                }
            }.launchIn(viewModelScope)
        }
    }

    fun saveToLocal(cityName:String){
        viewModelScope.launch {

            _weatherInfo.value.data?.let { w->

                val cityInfo=CityInfoModel( cityName = cityName, cityDegree = w.temperatureCurrent.maxDegree, cityStatus = w.status.name)
                val records= arrayListOf<RecordModel>()
                 w.temperatureRecords.forEach { i->
                     records.add(RecordModel( day = i.day, status = i.status.name, degree = i.maxDegree))
                 }

                addCityInfoToLocalUseCase(LocalWeatherInfoModel(cityInfo,records)).onEach {
                    when(it){
                        is UiEvent.Loading -> _localOperations.value= ChooserScreenStateHolder(isLoading = true)
                        is UiEvent.Success -> _localOperations.value= ChooserScreenStateHolder(isSuccess = true)
                        is UiEvent.Error -> _localOperations.value= ChooserScreenStateHolder(error = it.message.toString())
                    }

                }.launchIn(viewModelScope)



            }


        }
    }

}