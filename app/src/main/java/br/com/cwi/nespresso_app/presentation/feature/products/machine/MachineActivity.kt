package br.com.cwi.nespresso_app.presentation.feature.products.machine

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityMachineBinding
import br.com.cwi.nespresso_app.presentation.extension.visibleOrGone
import br.com.cwi.nespresso_app.presentation.feature.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.presentation.feature.products.coffee.CapsulesAdapter

class MachineActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityMachineBinding

    private val viewModel = MachineViewModel()

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMachineBinding.inflate(layoutInflater)
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

        viewModel.machines.observe(this@MachineActivity) { list ->
            val recyclerView = binding.rvMachines

            recyclerView.addItemDecoration(
                DividerItemDecoration(this@MachineActivity, DividerItemDecoration.VERTICAL)
            )

            recyclerView.adapter = MachineAdapter(this@MachineActivity, list)
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }

        viewModel.loading.observe(this@MachineActivity, {
            binding.loadingView.root.visibleOrGone(it)
        })

        viewModel.error.observe(this@MachineActivity, {
            binding.errorView.root.visibleOrGone(it)
        })

        binding.errorView.bTryAgain.setOnClickListener {
            viewModel.fetchMachines()
        }

        viewModel.fetchMachines()
    }
}