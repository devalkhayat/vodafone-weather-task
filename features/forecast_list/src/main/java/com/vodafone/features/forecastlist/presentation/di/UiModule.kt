package com.vodafone.features.forecastlist.presentation.di

import com.vodafone.features.forecastlist.domain.use_cases.GetLocalFutureInfoUseCase
import com.vodafone.features.forecastlist.presentation.screens.ForeCastListScreenViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideHomeScreenViewModel(getLocalFutureInfoUseCase: GetLocalFutureInfoUseCase): ForeCastListScreenViewModel {
        return ForeCastListScreenViewModel(getLocalFutureInfoUseCase)
    }
}