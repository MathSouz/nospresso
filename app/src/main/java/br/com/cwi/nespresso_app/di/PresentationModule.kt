package br.com.cwi.nespresso_app.di

import br.com.cwi.nespresso_app.presentation.feature.products.accessory.AccessoriesViewModel
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.CoffeeViewModel
import br.com.cwi.nespresso_app.presentation.feature.products.machine.MachineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CoffeeViewModel(get()) }
    viewModel { MachineViewModel(get()) }
    viewModel { AccessoriesViewModel(get()) }
}