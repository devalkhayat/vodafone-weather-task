package com.vodafone.features.city_chooser.domain.use_cases

import com.vodafone.core.util.UiEvent
import com.vodafone.features.city_chooser.domain.model.WeatherInfoModel
import com.vodafone.features.city_chooser.domain.repo.CityChooserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCurrentWeatherInfoUseCase @Inject constructor(private val cityChooserRepository: CityChooserRepository) {

    operator fun invoke(latitude: String , longitude: String , unit: String) =
        flow<UiEvent<WeatherInfoModel>> {
            emit(UiEvent.Loading())
            emit(
                UiEvent.Success(
                    cityChooserRepository.getCurrentWeatherInformation(
                        latitude ,
                        longitude ,
                        unit
                    )
                )
            )
        }.catch() {
            emit(UiEvent.Error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
}