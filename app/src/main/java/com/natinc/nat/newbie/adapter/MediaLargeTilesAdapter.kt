package com.natinc.nat.newbie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R

class MediaLargeTilesAdapter : RecyclerView.Adapter<MediaLargeTilesAdapter.MediaLargeTilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaLargeTilesViewHolder {

        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.nb_list_item_media_large_tiles, parent, false)
        return MediaLargeTilesViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MediaLargeTilesViewHolder, position: Int) {

    }


    class MediaLargeTilesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
