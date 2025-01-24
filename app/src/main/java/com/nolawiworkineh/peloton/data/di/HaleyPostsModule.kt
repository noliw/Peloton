package com.nolawiworkineh.peloton.data.di

import com.nolawiworkineh.peloton.data.network.HaleyApiService
import com.nolawiworkineh.peloton.data.network.HaleyRetrofitClient
import com.nolawiworkineh.peloton.data.network.PostsRepoImpl
import com.nolawiworkineh.peloton.domain.PostsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HaleyPostsModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = HaleyRetrofitClient.retrofit

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): HaleyApiService =
        retrofit.create(HaleyApiService::class.java)

    @Provides
    @Singleton
    fun providePostsRepoImpl(apiService: HaleyApiService): PostsRepo =
        PostsRepoImpl(apiService)

}