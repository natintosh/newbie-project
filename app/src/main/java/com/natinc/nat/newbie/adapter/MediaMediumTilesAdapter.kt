package com.natinc.nat.newbie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R

class MediaMediumTilesAdapter : RecyclerView.Adapter<MediaMediumTilesAdapter.MediaMediumTilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaMediumTilesViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.nb_list_item_media_medium_tiles, parent, false)
        return MediaMediumTilesViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MediaMediumTilesViewHolder, position: Int) {

    }

    class MediaMediumTilesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
