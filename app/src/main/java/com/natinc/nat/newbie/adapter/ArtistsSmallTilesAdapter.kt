package com.natinc.nat.newbie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R

class ArtistsSmallTilesAdapter(val callback: SetOnArtistSmallAdapterListener? = null) :
    RecyclerView.Adapter<ArtistsSmallTilesAdapter.ArtistsSmallTilesViewHolder>() {

    interface SetOnArtistSmallAdapterListener {
        fun onArtistItemClick(position: Int)
    }

    fun itemClick(position: Int) {
        callback?.onArtistItemClick(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsSmallTilesViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.nb_list_item_artist_small, parent, false)
        return ArtistsSmallTilesViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: ArtistsSmallTilesViewHolder, position: Int) {
        holder.apply {
            itemView.setOnClickListener { itemClick(position) }
        }
    }

    class ArtistsSmallTilesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
