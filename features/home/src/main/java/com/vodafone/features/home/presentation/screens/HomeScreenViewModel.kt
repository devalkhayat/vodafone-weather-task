package com.vodafone.features.home.presentation.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vodafone.core.util.UiEvent
import com.vodafone.features.home.domain.use_cases.GetLocalWeatherInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val getLocalWeatherInfoUseCase: GetLocalWeatherInfoUseCase):ViewModel(){

    private val _savedData=mutableStateOf(HomeScreenStateHolder())
    val savedData:State<HomeScreenStateHolder> get() = _savedData

    fun getData(){

        viewModelScope.launch {

            getLocalWeatherInfoUseCase().onEach {
                when(it){
                    is UiEvent.Error -> _savedData.value=HomeScreenStateHolder(error = it.message.toString())
                    is UiEvent.Loading -> _savedData.value=HomeScreenStateHolder(isLoading = true)
                    is UiEvent.Success -> _savedData.value=HomeScreenStateHolder(isSuccess=true,data=it.data)
                }

            }.launchIn(viewModelScope)
        }
    }
}