package com.natinc.nat.newbie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R

class PlaylistAdapter :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.nb_player_playlist_item, parent, false)
        return PlaylistViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {

    }

    class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
