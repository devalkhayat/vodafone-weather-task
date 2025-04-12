package com.vodafone.weathernowlater.di

import com.vodafone.features.city_chooser.presentation.navigation.CityChooserApi
import com.vodafone.features.home.presentation.navigation.HomeApi
import com.vodafone.weathernowlater.navigation.NavigationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(cityChooser: CityChooserApi,home: HomeApi
    ): NavigationProvider {
        return NavigationProvider(cityChooser,home)
    }
}