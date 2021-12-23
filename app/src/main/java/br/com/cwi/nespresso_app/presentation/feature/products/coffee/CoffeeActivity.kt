package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityCoffeeBinding
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import br.com.cwi.nespresso_app.presentation.feature.base.BaseBottomNavigation
import org.koin.androidx.viewmodel.ext.android.viewModel

class CoffeeActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityCoffeeBinding

    private val viewModel : CoffeeViewModel by viewModel()

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoffeeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpViewModel()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun getBottomNavigation() = binding.bottomNavigation

    private fun setUpViewModel() {

        viewModel.coffees.observe(this@CoffeeActivity) { list ->
            val recyclerView = binding.rvCaps

            recyclerView.addItemDecoration(
                DividerItemDecoration(this@CoffeeActivity, DividerItemDecoration.VERTICAL)
            )

            recyclerView.adapter = CapsulesAdapter(this@CoffeeActivity, list) {
                viewModel.setFavorite(it)
            }
        }

        viewModel.loading.observe(this@CoffeeActivity, {
            binding.loadingView.root.visibleOrGone(it)
        })

        viewModel.error.observe(this@CoffeeActivity, {
            binding.errorView.root.visibleOrGone(it)
        })

        binding.errorView.bTryAgain.setOnClickListener {
            viewModel.fetchCoffees()
        }

        viewModel.fetchCoffees()
    }
}