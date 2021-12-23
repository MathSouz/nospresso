package br.com.cwi.nespresso_app.presentation.feature.products.coffeeInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityDetailedCoffeeBinding
import br.com.cwi.nespresso_app.domain.entity.DetailedCoffee
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailedCoffeeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedCoffeeBinding

    private val viewModel : DetailedCoffeeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedCoffeeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setup()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setup() {
        intent.extras?.getInt("id")?.let { id ->
            viewModel.fetchDetailedCoffees(id)

            viewModel.loading.observe(this@DetailedCoffeeActivity, {
                binding.loadingView.root.visibleOrGone(it)
            })

            viewModel.error.observe(this@DetailedCoffeeActivity, {
                binding.errorView.root.visibleOrGone(it)
            })

            binding.errorView.bTryAgain.setOnClickListener {
                viewModel.fetchDetailedCoffees(id)
            }

            viewModel.coffees.observe(this, { initViewValues(it) })
        }
    }

    private fun initViewValues(it : DetailedCoffee) {
        val maxIntensity = 20
        supportActionBar?.title = it.name

        binding.tvDescription.text = it.description
        binding.tvRoasting.text = it.roasting
        binding.tvPrice.text = it.unitPrice.toMoneyFormat()
        binding.tvOrigin.text = it.origin
        binding.tvProfile.text = it.profile
        it.intensity?.let { intensity ->
            binding.lpiIntensity.progress = ((intensity.toDouble() / maxIntensity.toDouble()) * 100.0).toInt()
            binding.tvIntensity.text = getString(R.string.txt_intensity, intensity)
            binding.lpiIntensity.visibleOrGone(true)
            binding.tvIntensity.visibleOrGone(true)
        }

        Glide.with(this).load(it.urlImage).into(binding.ivCoffee)
    }
}