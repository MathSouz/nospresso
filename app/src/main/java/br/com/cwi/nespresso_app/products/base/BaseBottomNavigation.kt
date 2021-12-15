package br.com.cwi.nespresso_app.products.base

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.bag.BagActivity
import br.com.cwi.nespresso_app.favorites.FavoritesActivity
import br.com.cwi.nespresso_app.products.ProductsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseBottomNavigation : AppCompatActivity() {

    abstract fun bottomNavigation() : BottomNavigationView
    abstract fun defaultMenuItemId() : Int

    fun setUpBottomNavigation() {
        bottomNavigation().setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.products_menu -> {
                    startActivity(Intent(this, ProductsActivity::class.java))
                }
                R.id.favorites_menu -> {
                    startActivity(Intent(this, FavoritesActivity::class.java))
                }
                R.id.bag_menu -> {
                    startActivity(Intent(this, BagActivity::class.java))
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onResume() {
        super.onResume()
        //TODO: bug
        //bottomNavigation().selectedItemId = defaultMenuItemId()
    }
}