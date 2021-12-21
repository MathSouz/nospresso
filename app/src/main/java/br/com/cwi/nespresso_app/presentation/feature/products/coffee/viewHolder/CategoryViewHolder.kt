package br.com.cwi.nespresso_app.presentation.feature.products.coffee.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.databinding.ItemCapCategoryBinding
import br.com.cwi.nespresso_app.domain.entity.CoffeeCategory

class CategoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val tvCategory = ItemCapCategoryBinding.bind(item).tvCapTitleCategory

    fun bind(item: CoffeeCategory) {
        tvCategory.text = item.category
    }
}