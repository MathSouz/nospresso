package br.com.cwi.nespresso_app.presentation.feature.products.accessory

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.databinding.ActivityAcessoriesBinding
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import br.com.cwi.nespresso_app.presentation.feature.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.CapsulesAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccessoriesActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityAcessoriesBinding

    private val viewModel = AccessoriesViewModel()

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAcessoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        super.onCreate(savedInstanceState)
        setUpViewModel()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun getBottomNavigation() = binding.bottomNavigation

    private fun setUpViewModel() {
        viewModel.accessories.observe(this@AccessoriesActivity) { list ->
            val recyclerView = binding.rvAccessories

            recyclerView.addItemDecoration(
                DividerItemDecoration(this@AccessoriesActivity, DividerItemDecoration.VERTICAL)
            )

            recyclerView.adapter = AccessoriesAdapter(this@AccessoriesActivity, list)
        }

        viewModel.loading.observe(this@AccessoriesActivity, {
            binding.loadingView.root.visibleOrGone(it)
        })

        viewModel.error.observe(this@AccessoriesActivity, {
            binding.errorView.root.visibleOrGone(it)
        })

        binding.errorView.bTryAgain.setOnClickListener {
            viewModel.fetchAccessories()
        }

        viewModel.fetchAccessories()

    }
}