package com.natinc.nat.newbie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R

class ArtistsMediumTilesAdapter : RecyclerView.Adapter<ArtistsMediumTilesAdapter.ArtistsMediumTilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsMediumTilesViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.nb_list_item_artist_medium_tiles, parent, false)
        return ArtistsMediumTilesViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ArtistsMediumTilesViewHolder, position: Int) {

    }

    class ArtistsMediumTilesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
