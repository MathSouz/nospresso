package br.com.cwi.nespresso_app.presentation.feature.products.accessory.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.databinding.ItemCapCategoryBinding
import br.com.cwi.nespresso_app.domain.entity.AccessoryCategory

class AccessoryCategoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val tvCategory = ItemCapCategoryBinding.bind(item).tvCapTitleCategory

    fun bind(item: AccessoryCategory) {
        tvCategory.text = item.category
    }
}