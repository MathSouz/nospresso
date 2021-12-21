package br.com.cwi.nespresso_app.di

import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import org.koin.dsl.module

val dataModule = module {
    single { RetrofitConfig.service }
    factory<CoffeeRepository> { CoffeeRepositoryImpl(get()) }
}