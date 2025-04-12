package com.vodafone.features.city_chooser.presentation.di

import com.vodafone.features.city_chooser.domain.use_cases.AddCityInfoToLocalUseCase
import com.vodafone.features.city_chooser.domain.use_cases.GetCurrentWeatherInfoUseCase
import com.vodafone.features.city_chooser.presentation.navigation.CityChooserApi
import com.vodafone.features.city_chooser.presentation.navigation.CityChooserApiImpl
import com.vodafone.features.city_chooser.presentation.screens.chooser.ChooserScreenViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideCityChooserApi(): CityChooserApi {
        return CityChooserApiImpl()
    }

    @Provides
    fun provideChooserScreenViewModel(getCurrentWeatherInfoUseCase: GetCurrentWeatherInfoUseCase,addCityInfoToLocalUseCase: AddCityInfoToLocalUseCase): ChooserScreenViewModel {
        return ChooserScreenViewModel(getCurrentWeatherInfoUseCase,addCityInfoToLocalUseCase)
    }

}