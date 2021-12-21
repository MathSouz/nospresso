package br.com.cwi.nespresso_app.presentation.feature.products.accessory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.domain.entity.Accessory
import br.com.cwi.nespresso_app.domain.entity.AccessoryCategory
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.presentation.feature.base.BaseViewModel

class AccessoriesViewModel : BaseViewModel() {

    private val _accessories = MutableLiveData<List<Type>>()
    val accessories : LiveData<List<Type>> = _accessories

    private val repository : CoffeeRepository = CoffeeRepositoryImpl()

    fun fetchAccessories() {
        launch {
            val categoryList = repository.getAccessories()
            _accessories.postValue(getAccessoriesType(categoryList))
        }
    }

    private fun getAccessoriesType(categoryList: List<AccessoryCategory>): List<Type> {
        val list = mutableListOf<Type>()

        categoryList.forEach {
            list.add(it)
            list.addAll(it.accessories)
        }
        return list
    }
}