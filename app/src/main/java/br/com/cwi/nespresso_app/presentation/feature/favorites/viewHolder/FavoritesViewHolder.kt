package br.com.cwi.nespresso_app.presentation.feature.favorites.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.databinding.ItemFavoriteBinding
import br.com.cwi.nespresso_app.databinding.ItemMachineBinding

class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvItemName = ItemFavoriteBinding.bind(itemView).tvItemName
    val tvItemPrice = ItemFavoriteBinding.bind(itemView).tvItemPrice
    val tvItemType = ItemFavoriteBinding.bind(itemView).tvItemType
    val ivItemPicture = ItemFavoriteBinding.bind(itemView).ivItemPicture
}