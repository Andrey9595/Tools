package com.example.home.di

import com.example.cloudservice.CloudService
import com.example.cloudservice.CloudServiceImpl
import com.example.cloudservice.ProvideDatabase
import com.example.cloudstorage.CloudStorage
import com.example.cloudstorage.CloudStorageImpl
import com.example.cloudstorage.ProvideStorage
import com.example.home.data.HomeRepositoryImpl
import com.example.home.domain.HomeFlowWrapper
import com.example.home.domain.HomeInteractor
import com.example.home.domain.HomeRepository
import com.example.home.ui.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module

fun homeModule() = module {

    viewModelOf(::HomeViewModel)

    factory { HomeInteractor.Base(get()) } bind HomeInteractor::class

    factory { HomeRepositoryImpl(get(), get()) } bind HomeRepository::class

    factory { CloudServiceImpl(get()) } bind CloudService::class

    factory { CloudStorageImpl(get()) } bind CloudStorage::class

    factory { ProvideStorage.Base() } bind ProvideStorage::class

    factory { ProvideDatabase.Base(androidApplication()) } bind ProvideDatabase::class

    factory { HomeFlowWrapper.Base() } binds arrayOf(
        HomeFlowWrapper.Post::class,
        HomeFlowWrapper.Collect::class,
        HomeFlowWrapper.Mutable::class
    )
}