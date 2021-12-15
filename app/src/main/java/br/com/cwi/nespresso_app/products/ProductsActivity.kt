package br.com.cwi.nespresso_app.products

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.bag.BagActivity
import br.com.cwi.nespresso_app.databinding.ActivityProductsBinding
import br.com.cwi.nespresso_app.favorites.FavoritesActivity
import br.com.cwi.nespresso_app.products.acessories.AcessoriesActivity
import br.com.cwi.nespresso_app.products.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.products.coffee.CoffeeActivity
import br.com.cwi.nespresso_app.products.machine.MachineActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProductsActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityProductsBinding

    override fun bottomNavigation(): BottomNavigationView  = binding.bottomNavigation
    override fun defaultMenuItemId(): Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpProductsActions()
        setUpBottomNavigation()
    }

    private fun setUpProductsActions() {
        binding.contentCoffees.root.setOnClickListener {
            val intent = Intent(this, CoffeeActivity::class.java)
            startActivity(intent)
        }

        binding.contentMachines.root.setOnClickListener {
            val intent = Intent(this, MachineActivity::class.java)
            startActivity(intent)
        }

        binding.contentAccessories.root.setOnClickListener {
            val intent = Intent(this, AcessoriesActivity::class.java)
            startActivity(intent)
        }
    }
}