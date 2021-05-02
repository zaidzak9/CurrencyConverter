package com.zaidzakir.currencyconverter.dependencyInjection

import com.zaidzakir.currencyconverter.model.Api
import com.zaidzakir.currencyconverter.repository.DefaultMainRepository
import com.zaidzakir.currencyconverter.repository.MainRepository
import com.zaidzakir.currencyconverter.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *Created by Zaid Zakir
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    suspend fun provideCurrencyApi(): Api = Retrofit.Builder()
        .baseUrl("http://api.exchangeratesapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(api:Api) : MainRepository = DefaultMainRepository(api)

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }

}