package com.example.onesignalsampleproject.di

import com.example.onesignalsampleproject.ExampleOneSignal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun provideExampleOneSignal(): ExampleOneSignal = ExampleOneSignal()

}