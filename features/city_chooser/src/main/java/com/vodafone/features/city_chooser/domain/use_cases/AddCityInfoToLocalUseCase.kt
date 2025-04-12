package com.vodafone.features.city_chooser.domain.use_cases

import com.vodafone.core.util.UiEvent
import com.vodafone.features.city_chooser.domain.model.LocalWeatherInfoModel
import com.vodafone.features.city_chooser.domain.repo.CityChooserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class AddCityInfoToLocalUseCase @Inject constructor(private val cityChooserRepository: CityChooserRepository) {

    operator fun invoke(localWeatherInfoModel: LocalWeatherInfoModel) = flow<UiEvent<Boolean>> {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(cityChooserRepository.addToLocal(localWeatherInfoModel)))
    }.catch() {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}