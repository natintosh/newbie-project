package com.natinc.nat.newbie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.nb_list_item_history, parent, false)
        return HistoryViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {

    }

    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
