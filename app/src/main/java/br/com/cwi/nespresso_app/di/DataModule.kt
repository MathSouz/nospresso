package br.com.cwi.nespresso_app.di

import br.com.cwi.nespresso_app.data.database.AppDatabase
import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import br.com.cwi.nespresso_app.data.repository.CoffeeLocalRepositoryImpl
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.domain.repository.CoffeeLocalRepository
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    single { RetrofitConfig.service }
    single { AppDatabase.create(androidApplication()) }
    factory<CoffeeRepository> { CoffeeRepositoryImpl(get()) }
    factory<CoffeeLocalRepository> { CoffeeLocalRepositoryImpl(get()) }
}