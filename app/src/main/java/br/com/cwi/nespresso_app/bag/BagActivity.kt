package br.com.cwi.nespresso_app.bag

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityBagBinding
import br.com.cwi.nespresso_app.favorites.FavoritesActivity
import br.com.cwi.nespresso_app.products.ProductsActivity
import br.com.cwi.nespresso_app.products.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class BagActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityBagBinding

    override fun bottomNavigation(): BottomNavigationView  = binding.bottomNavigation
    override fun defaultMenuItemId(): Int = R.id.bag_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBagBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNavigation()
    }


}