package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.domain.entity.DetailedCoffee
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.presentation.feature.base.BaseViewModel

class DetailedCoffeeViewModel(private val repository: CoffeeRepository) : BaseViewModel() {

    private val _coffees = MutableLiveData<DetailedCoffee>()
    val coffees: LiveData<DetailedCoffee> = _coffees

    fun fetchDetailedCoffees(id : Int) {
        launch {
            val categoryList = repository.getDetailedCoffee(id)
            _coffees.postValue(categoryList)
        }
    }
}