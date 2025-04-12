package com.vodafone.features.home.domain.use_cases

import com.vodafone.core.util.UiEvent
import com.vodafone.features.home.domain.model.CityWeatherInfoModel
import com.vodafone.features.home.domain.repo.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetLocalWeatherInfoUseCase @Inject constructor(private val homeRepository: HomeRepository){
    operator fun invoke() = flow<UiEvent<CityWeatherInfoModel>> {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(homeRepository.getStoredInformation()))
    }.catch() {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}