package br.com.cwi.nespresso_app.presentation.feature.products.coffee.viewHolder

import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ItemCoffeeCapsuleBinding
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import br.com.cwi.nespresso_app.presentation.feature.products.coffeeInfo.DetailedCoffeeActivity
import com.bumptech.glide.Glide

class CapsuleViewHolder(
    itemView: View,
    private val onFavoriteClick: (Coffee) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val tvTitle = ItemCoffeeCapsuleBinding.bind(itemView).tvCapsuleTitle
    private val tvSubtitle = ItemCoffeeCapsuleBinding.bind(itemView).tvCapsuleSubtitle
    private val ivImage = ItemCoffeeCapsuleBinding.bind(itemView).ivCapsuleImage
    private val tvIntensity = ItemCoffeeCapsuleBinding.bind(itemView).tvCapsuleIntensity
    private val tvPrice = ItemCoffeeCapsuleBinding.bind(itemView).tvCapsulePrice
    private val ivFavorite = ItemCoffeeCapsuleBinding.bind(itemView).ivFavorite
    private val root = ItemCoffeeCapsuleBinding.bind(itemView).root

    fun bind(item: Coffee) {
        val context = itemView.context
        tvTitle.text = item.name
        tvSubtitle.text = item.description
        tvIntensity.text = context.getString(R.string.txt_intensity, item.intensity)
        tvPrice.text = item.unitPrice.toMoneyFormat()

        root.setOnClickListener {
            val coffeeInfoIntent = Intent(context, DetailedCoffeeActivity::class.java)
            coffeeInfoIntent.putExtra("id", item.id)
            context.startActivity(coffeeInfoIntent)
        }

        with(ivFavorite) {

            setOnClickListener {
                item.favorite = !item.favorite
                setImageDrawable(getFavoriteIcon(item))
                onFavoriteClick(item)
            }
        }

        Glide.with(context)
            .load(item.urlImage)
            .into(ivImage)
    }

    private fun getFavoriteIcon(coffee: Coffee) = ContextCompat.getDrawable(
        itemView.context,
        if (coffee.favorite) R.drawable.ic_favorite_filled
        else R.drawable.ic_favorite_rounded
    )

}