package com.tappli.paging3

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

val COMPARATOR = object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem.toUpperCase() == newItem.toUpperCase()

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem
}

class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView: TextView = itemView.findViewById(android.R.id.text1)
}

class SampleDataAdapter : PagingDataAdapter<String, TextViewHolder>(COMPARATOR) {

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.textView.text = getItem(position) ?: "???"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val itemView = View.inflate(parent.context, android.R.layout.simple_list_item_1, null)
        return TextViewHolder(itemView)
    }
}