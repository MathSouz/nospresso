package br.com.cwi.nespresso_app.presentation.products.coffee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.base.toMoneyFormat
import br.com.cwi.nespresso_app.databinding.ItemCapCategoryBinding
import br.com.cwi.nespresso_app.databinding.ItemCoffeeCapsuleBinding
import br.com.cwi.nespresso_app.domain.entity.CoffeeCategory
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.domain.entity.ItemType
import br.com.cwi.nespresso_app.domain.entity.Type
import com.bumptech.glide.Glide

const val VIEW_TYPE_CATEGORY = 0

class CapsulesAdapter(val context: Context, private val list: List<Type>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == ItemType.CATEGORY.value) {

            val view = inflateView(R.layout.item_cap_category, parent)
            CategoryViewHolder(view)

        } else {

            val view = inflateView(R.layout.item_coffee_capsule, parent)
            CapsuleViewHolder(view)

        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = list[position]

        if (item.type.value == ItemType.CATEGORY.value) {

            item as CoffeeCategory
            (viewHolder as CategoryViewHolder).bind(item)

        } else {

            item as Coffee
            (viewHolder as CapsuleViewHolder).bind(context, item)

        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int) = list[position].type.value

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)
}

class CategoryViewHolder(item: View) : ViewHolder(item) {
    private val tvCategory = ItemCapCategoryBinding.bind(item).tvCapTitleCategory

    fun bind(item: CoffeeCategory) {
        tvCategory.text = item.category
    }
}

class CapsuleViewHolder(item: View) : ViewHolder(item) {
    private val tvTitle = ItemCoffeeCapsuleBinding.bind(item).tvCapsuleTitle
    private val tvSubtitle = ItemCoffeeCapsuleBinding.bind(item).tvCapsuleSubtitle
    private val ivImage = ItemCoffeeCapsuleBinding.bind(item).ivCapsuleImage
    private val tvIntensity = ItemCoffeeCapsuleBinding.bind(item).tvCapsuleIntensity
    private val tvPrice = ItemCoffeeCapsuleBinding.bind(item).tvCapsulePrice
    private val ivFavorite = ItemCoffeeCapsuleBinding.bind(item).ivFavorite

    fun bind(context: Context, item: Coffee) {
        tvTitle.text = item.name
        tvSubtitle.text = item.description
        tvIntensity.text = context.getString(R.string.txt_intensity, item.intensity)
        tvPrice.text = item.unitPrice.toMoneyFormat()

        Glide.with(context)
            .load(item.urlImage)
            .into(ivImage)
    }
}