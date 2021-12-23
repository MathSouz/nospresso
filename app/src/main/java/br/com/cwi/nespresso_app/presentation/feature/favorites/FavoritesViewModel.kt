package br.com.cwi.nespresso_app.presentation.feature.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.database.entity.ItemEntity
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.domain.repository.CoffeeLocalRepository
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import br.com.cwi.nespresso_app.presentation.feature.base.BaseViewModel

class FavoritesViewModel(
    private val repository: CoffeeRepository,
    private val localRepository: CoffeeLocalRepository
) : BaseViewModel(){

    private val _favorites = MutableLiveData<List<ItemEntity>>()
    val favorites: LiveData<List<ItemEntity>> = _favorites

    fun fetchFavorites() {
        launch {
            _favorites.postValue(localRepository.getAll())
        }
    }
}