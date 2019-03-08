package com.natinc.nat.newbie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R

class ItemSmallTilesAdapter : RecyclerView.Adapter<ItemSmallTilesAdapter.ItemSmallTilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSmallTilesViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.nb_list_item_small_tiles, parent, false)
        return ItemSmallTilesViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ItemSmallTilesViewHolder, position: Int) {

    }

    class ItemSmallTilesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
