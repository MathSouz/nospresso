package br.com.cwi.nespresso_app.favorites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.bag.BagActivity
import br.com.cwi.nespresso_app.databinding.ActivityFavoritesBinding
import br.com.cwi.nespresso_app.databinding.ActivityProductsBinding
import br.com.cwi.nespresso_app.products.ProductsActivity
import br.com.cwi.nespresso_app.products.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoritesActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityFavoritesBinding

    override fun bottomNavigation(): BottomNavigationView  = binding.bottomNavigation
    override fun defaultMenuItemId(): Int = R.id.favorites_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNavigation()
    }

}