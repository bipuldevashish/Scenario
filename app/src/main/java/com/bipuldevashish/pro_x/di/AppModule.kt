package com.bipuldevashish.pro_x.di

import com.bipuldevashish.pro_x.data.api.ApiService
import com.bipuldevashish.pro_x.data.api.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent:: class)
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(RetrofitBuilder.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService( retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}