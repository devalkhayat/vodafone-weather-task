package com.vodafone.features.home.presentation.di

import com.vodafone.features.home.domain.use_cases.GetLocalWeatherInfoUseCase
import com.vodafone.features.home.presentation.navigation.HomeApi
import com.vodafone.features.home.presentation.navigation.HomeApiImpl
import com.vodafone.features.home.presentation.screens.HomeScreenViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideHomeApi(): HomeApi {
        return HomeApiImpl()
    }

    @Provides
    fun provideHomeScreenViewModel(getLocalWeatherInfoUseCase: GetLocalWeatherInfoUseCase): HomeScreenViewModel {
        return HomeScreenViewModel(getLocalWeatherInfoUseCase)
    }
}