package br.com.cwi.nespresso_app.presentation.products.accessory

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.databinding.ActivityAcessoriesBinding
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigationActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccessoriesActivity : BaseBottomNavigationActivity() {

    private lateinit var binding: ActivityAcessoriesBinding

    private val repository = CoffeeRepositoryImpl()

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAcessoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        super.onCreate(savedInstanceState)
        setUpMachineList()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun getBottomNavigation() = binding.bottomNavigation

    private fun setUpMachineList() {

        CoroutineScope(Dispatchers.Main).launch {
            repository.getAccessories().let { categoryList ->
                val recyclerView = binding.rvAccessories

                recyclerView.addItemDecoration(
                    DividerItemDecoration(this@AccessoriesActivity, DividerItemDecoration.VERTICAL)
                )

                val accessoriesList = mutableListOf<Type>()

                categoryList.forEach {
                    accessoriesList.add(it)
                    accessoriesList.addAll(it.accessories)
                }

                recyclerView.adapter = AccessoriesAdapter(this@AccessoriesActivity, accessoriesList)
            }
        }
    }
}