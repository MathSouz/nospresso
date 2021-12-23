package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.domain.entity.CoffeeCategory
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.domain.repository.CoffeeLocalRepository
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.presentation.extension.toItem
import br.com.cwi.nespresso_app.presentation.feature.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CoffeeViewModel(
    private val repository: CoffeeRepository,
    private val localRepository: CoffeeLocalRepository
    ) : BaseViewModel() {

    private val _coffees = MutableLiveData<List<Type>>()
    val coffees: LiveData<List<Type>> = _coffees

    fun fetchCoffees() {
        launch {
            val categoryList = repository.getCoffees()
            _coffees.postValue(getCoffeesType(categoryList))
        }
    }

    private fun getCoffeesType(categoryList: List<CoffeeCategory>): List<Type> {
        val coffeeList = mutableListOf<Type>()

        categoryList.forEach {
            coffeeList.add(it)
            coffeeList.addAll(it.coffees)
        }
        return coffeeList
    }

    fun setFavorite(it: Coffee) {
        val item = it.toItem()
        if (localRepository.getAll()?.contains(item) == true) {
            localRepository.remove(it.toItem())
        } else {
            localRepository.add(it.toItem())
        }
    }
}