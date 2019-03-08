package com.natinc.nat.newbie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R

class StaggeredGridMediaTilesAdapter : RecyclerView.Adapter<StaggeredGridMediaTilesAdapter.StaggeredGridViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return position % 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaggeredGridViewHolder {
        var layoutId = R.layout.nb_list_item_media_medium_tiles
        if (viewType != 0) {
            layoutId = R.layout.nb_list_item_media_large_tiles
        }

        val layoutView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return StaggeredGridViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: StaggeredGridViewHolder, position: Int) {

    }


    class StaggeredGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}