package com.natinc.nat.newbie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R

class MediaSmallTilesAdapter : RecyclerView.Adapter<MediaSmallTilesAdapter.MediaSmallTilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaSmallTilesViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.nb_list_item_media_small_tiles, parent, false)
        return MediaSmallTilesViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MediaSmallTilesViewHolder, position: Int) {

    }

    class MediaSmallTilesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
