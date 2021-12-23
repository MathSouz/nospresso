package br.com.cwi.nespresso_app.presentation.feature.favorites

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.database.entity.ItemEntity
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import br.com.cwi.nespresso_app.presentation.feature.favorites.viewHolder.FavoritesViewHolder
import br.com.cwi.nespresso_app.presentation.feature.products.machine.viewHolder.MachineViewHolder
import com.bumptech.glide.Glide

class FavoritesAdapter(
    val context: Context,
    private val list: List<ItemEntity>
) : RecyclerView.Adapter<FavoritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        with(holder) {
            list[position].let {

                holder.tvItemName.text = it.name
                holder.tvItemType.text = it.type
                holder.tvItemPrice.text = it.unitPrice.toMoneyFormat()

                Glide.with(context).load(it.urlImage).into(holder.ivItemPicture)
            }
        }

    }

    override fun getItemCount(): Int = list.size
}
