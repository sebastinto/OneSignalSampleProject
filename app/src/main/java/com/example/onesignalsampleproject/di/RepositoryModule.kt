package com.example.onesignalsampleproject.di

import androidx.work.WorkManager
import com.example.onesignalsampleproject.repository.ExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideExampleRepository(workManager: WorkManager): ExampleRepository =
        ExampleRepository(workManager = workManager)
}