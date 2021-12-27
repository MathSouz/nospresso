package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.FragmentCoffeeBinding
import br.com.cwi.nespresso_app.domain.entity.Type
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

const val EXTRA_COFFEE_ID = "EXTRA_COFFEE_ID"

class CoffeeFragment : Fragment() {

    private lateinit var binding: FragmentCoffeeBinding

    private val viewModel: CoffeeViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoffeeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.coffees.observe(viewLifecycleOwner) { list ->
            setUpCoffeeRecyclerView(list)
        }
        viewModel.fetchCoffees()
    }

    private fun setUpCoffeeRecyclerView(list: List<Type>) {
        binding.rvCaps.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = CapsulesAdapter(list, onFavoriteClick = {
                viewModel.setFavorite(it)
            }, onItemClick = {
                navigateToCoffeeDetail(it.id)
            })
        }
    }

    private fun navigateToCoffeeDetail(id: Int) {
        findNavController().navigate(
            R.id.coffee_detail_fragment,
            bundleOf(
                Pair(EXTRA_COFFEE_ID, id)
            )
        )
    }
}
