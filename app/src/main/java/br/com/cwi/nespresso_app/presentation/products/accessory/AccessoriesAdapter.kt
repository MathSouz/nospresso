package br.com.cwi.nespresso_app.presentation.products.accessory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.base.toMoneyFormat
import br.com.cwi.nespresso_app.data.entity.accessories.AccessoriesResponse
import br.com.cwi.nespresso_app.data.entity.accessories.AccessoryCategoryResponse
import br.com.cwi.nespresso_app.data.entity.accessories.AccessoryType
import br.com.cwi.nespresso_app.databinding.ItemAccessoryBinding
import br.com.cwi.nespresso_app.databinding.ItemCapCategoryBinding
import br.com.cwi.nespresso_app.domain.entity.Accessory
import br.com.cwi.nespresso_app.domain.entity.AccessoryCategory
import br.com.cwi.nespresso_app.domain.entity.ItemType
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.presentation.products.coffee.VIEW_TYPE_CATEGORY
import com.bumptech.glide.Glide

class AccessoriesAdapter(val context: Context, private val list: List<Type>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == VIEW_TYPE_CATEGORY) {
            AccessoryCategoryViewHolder(inflateView(R.layout.item_cap_category, parent))
        } else {
            AccessoryViewHolder(inflateView(R.layout.item_accessory, parent))
        }
    }

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        if (item.type.value == ItemType.CATEGORY.value) {

            item as AccessoryCategory
            (holder as AccessoryCategoryViewHolder).bind(item)

        }

        else {

            item as Accessory
            (holder as AccessoryViewHolder).bind(context, item)

        }
    }

    override fun getItemViewType(position: Int) = list[position].type.value

    override fun getItemCount() = list.size
}

class AccessoryCategoryViewHolder(item: View) : ViewHolder(item) {
    private val tvCategory = ItemCapCategoryBinding.bind(item).tvCapTitleCategory

    fun bind(item: AccessoryCategory) {
        tvCategory.text = item.category
    }
}

class AccessoryViewHolder(item: View) : ViewHolder(item) {
    private val tvTitle = ItemAccessoryBinding.bind(item).tvAccessoryTitle
    private val tvPrice = ItemAccessoryBinding.bind(item).tvAccessoryPrice
    private val ivImage = ItemAccessoryBinding.bind(item).ivAccessoryImage

    fun bind(context: Context, item: Accessory) {
        tvTitle.text = item.name
        tvPrice.text = item.unitPrice.toMoneyFormat()

        Glide.with(context).load(item.urlImage).into(ivImage)
    }
}