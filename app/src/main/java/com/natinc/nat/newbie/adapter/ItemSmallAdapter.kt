package com.natinc.nat.newbie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R
import com.natinc.nat.newbie.utility.LibraryTitles

data class ItemSmallAdapter(val context: Context?, var dataSet: List<LibraryTitles>? = null, val callback: SetOnItemSmallAdapterListener? = null) :
        RecyclerView.Adapter<ItemSmallAdapter.ItemSmallViewHolder>() {

    interface SetOnItemSmallAdapterListener {
        fun onItemSmallClickListener(position: Int)
    }

    private fun listItemClick(position: Int) {
        callback?.onItemSmallClickListener(position)
    }

    fun setDateSet(dataSet: List<LibraryTitles>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSmallViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.nb_list_item_small, parent, false)
        return ItemSmallViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return dataSet?.size ?: 0
    }

    override fun onBindViewHolder(holder: ItemSmallViewHolder, position: Int) {
        holder.apply {
            listItemTitleLabel.text = dataSet?.get(position)?.s
            itemView.setOnClickListener { listItemClick(position) }
        }
    }

    class ItemSmallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val listItemTitleLabel: TextView = itemView.findViewById(R.id.listItemSmallTitleTextLabel)
    }
}
