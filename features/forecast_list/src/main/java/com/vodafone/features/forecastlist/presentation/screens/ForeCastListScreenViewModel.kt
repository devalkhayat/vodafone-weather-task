package com.vodafone.features.forecastlist.presentation.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vodafone.core.util.UiEvent
import com.vodafone.features.forecastlist.domain.use_cases.GetLocalFutureInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForeCastListScreenViewModel @Inject constructor(private val getLocalFutureInfoUseCase: GetLocalFutureInfoUseCase):
    ViewModel() {

     var _state=mutableStateOf(ForeCastListScreenStateHolder())
         private set

    fun onAction(intent:ForeCastListScreenIntent){

        when(intent){
            ForeCastListScreenIntent.GetData -> getData()
        }

    }
    fun getData(){

        viewModelScope.launch {

            getLocalFutureInfoUseCase().onEach {
                when(it){
                    is UiEvent.Error -> _state.value=ForeCastListScreenStateHolder(error = it.message.toString())
                    is UiEvent.Loading -> _state.value=ForeCastListScreenStateHolder(isLoading = true)
                    is UiEvent.Success -> _state.value=ForeCastListScreenStateHolder(isSuccess=true , data=it.data)
                }

            }.launchIn(viewModelScope)
        }

    }

}