package br.com.cwi.nespresso_app.presentation.feature.products.coffeeInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.nespresso_app.databinding.ActivityDetailedCoffeeBinding
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailedCoffeeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedCoffeeBinding

    val viewModel : DetailedCoffeeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedCoffeeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.extras?.getInt("id")

        if(id != null) {
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

        } else {
            finish()
        }

        viewModel.coffees.observe(this, {
            val maxIntensity = 13
            supportActionBar?.title = it.name

            binding.tvDescription.text = it.description
            binding.tvRoasting.text = it.roasting
            binding.tvIntensity.text = "Intensidade: ${it.intensity.toString()}"
            binding.tvPrice.text = it.unitPrice.toMoneyFormat()
            binding.tvOrigin.text = it.origin
            binding.tvProfile.text = it.profile
            it.intensity?.let { intensity ->
                binding.lpiIntensity.progress = ((intensity.toDouble() / maxIntensity.toDouble()) * 100.0).toInt()
            }

            Glide.with(this).load(it.urlImage).into(binding.ivCoffee)
        })
    }
}