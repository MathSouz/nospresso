package br.com.cwi.nespresso_app.presentation.feature.favorites

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityCoffeeBinding
import br.com.cwi.nespresso_app.presentation.feature.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.databinding.ActivityFavoritesBinding
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.CoffeeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesActivity : BaseBottomNavigation() {

    private lateinit var binding : ActivityFavoritesBinding

    private val viewModel : FavoritesViewModel by viewModel()

    override val currentTab: Int = R.id.favorites_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setup()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setup() {

        viewModel.favorites.observe(this) {
            binding.rvFavorites.addItemDecoration(
                DividerItemDecoration(this@FavoritesActivity, DividerItemDecoration.VERTICAL)
            )

            binding.rvFavorites.adapter = FavoritesAdapter(this@FavoritesActivity, it)
            binding.rvFavorites.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        }

        viewModel.loading.observe(this@FavoritesActivity, {
            binding.loadingView.root.visibleOrGone(it)
        })

        viewModel.error.observe(this@FavoritesActivity, {
            binding.errorView.root.visibleOrGone(it)
        })

        viewModel.fetchFavorites()
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.bottomNavigation
}