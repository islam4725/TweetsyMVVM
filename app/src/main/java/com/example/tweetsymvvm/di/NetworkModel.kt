package com.example.tweetsymvvm.di

import com.example.tweetsymvvm.Api.TweetsyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
//this is hilt package which give us the objects
@Module
@InstallIn(SingletonComponent::class)
class NetworkModel {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://192.168.0.100/MyMVVMAPI/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideTweetsyApi(retrofit: Retrofit) : TweetsyApi{
        return retrofit.create(TweetsyApi::class.java)
    }
}