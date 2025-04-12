package com.vodafone.data.repository.home.di

import com.vodafone.data.datasource.local.AppDatabase
import com.vodafone.data.repository.home.repo.HomeRepoImpl
import com.vodafone.features.home.domain.repo.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun  provideHomeRepo(db: AppDatabase):HomeRepository{
        return HomeRepoImpl(db)
    }
}