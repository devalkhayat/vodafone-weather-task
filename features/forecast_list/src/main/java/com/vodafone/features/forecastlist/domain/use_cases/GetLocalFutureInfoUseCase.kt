package com.vodafone.features.forecastlist.domain.use_cases

import com.vodafone.core.util.UiEvent
import com.vodafone.features.forecastlist.domain.model.LocalFutureWeatherModel
import com.vodafone.features.forecastlist.domain.repo.ForeCastListRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetLocalFutureInfoUseCase @Inject constructor(private val foreCastListRepository: ForeCastListRepository){
    operator fun invoke() = flow<UiEvent<List<LocalFutureWeatherModel>>> {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(foreCastListRepository.getStoredInformation()))
    }.catch() {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}