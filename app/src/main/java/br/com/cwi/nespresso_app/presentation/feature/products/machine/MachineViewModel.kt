package br.com.cwi.nespresso_app.presentation.feature.products.machine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.domain.entity.CoffeeCategory
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.presentation.feature.base.BaseViewModel

class MachineViewModel(private val repository: CoffeeRepository) : BaseViewModel() {
    private val _machines = MutableLiveData<List<Machine>>()
    val machines: LiveData<List<Machine>> = _machines

    fun fetchMachines() {
        launch {
            val categoryList = repository.getMachines()
            _machines.postValue(categoryList)
        }
    }
}