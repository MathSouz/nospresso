package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.FragmentCoffeeDetailBinding
import br.com.cwi.nespresso_app.domain.entity.DetailedCoffee
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CoffeeDetailFragment : Fragment() {

    private lateinit var binding: FragmentCoffeeDetailBinding

    private val viewModel: DetailedCoffeeViewModel by sharedViewModel()

    private val coffeeId by lazy {
        arguments?.getInt(EXTRA_COFFEE_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoffeeDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coffeeId?.let { viewModel.fetchDetailedCoffees(it) }
        viewModel.coffees.observe(viewLifecycleOwner, { initViewValues(it) })
    }

    private fun initViewValues(it : DetailedCoffee) {
        val maxIntensity = 20
        // não é jeito mais correto
        (activity as CoffeeHostActivity).supportActionBar?.title = it.name

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
