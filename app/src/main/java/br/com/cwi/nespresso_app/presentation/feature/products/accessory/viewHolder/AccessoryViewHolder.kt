package br.com.cwi.nespresso_app.presentation.feature.products.accessory.viewHolder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.base.toMoneyFormat
import br.com.cwi.nespresso_app.databinding.ItemAccessoryBinding
import br.com.cwi.nespresso_app.domain.entity.Accessory
import com.bumptech.glide.Glide

class AccessoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val tvTitle = ItemAccessoryBinding.bind(item).tvAccessoryTitle
    private val tvPrice = ItemAccessoryBinding.bind(item).tvAccessoryPrice
    private val ivImage = ItemAccessoryBinding.bind(item).ivAccessoryImage

    fun bind(context: Context, item: Accessory) {
        tvTitle.text = item.name
        tvPrice.text = item.unitPrice.toMoneyFormat()

        Glide.with(context).load(item.urlImage).into(ivImage)
    }
}