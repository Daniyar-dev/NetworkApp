package com.example.networkapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.networkapp.R

class CategoryRvAdapter(private val list: List<String>, private val categoryClick: (String) -> Unit): RecyclerView.Adapter<CategoryViewHolder>() {

    private var selectedItem = -1
    private var lastSelectedItem = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_categories, parent, false)
        return CategoryViewHolder(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryText.text = list[position]
        holder.container.setOnClickListener {
            categoryClick(list[position])
            selectedItem = holder.adapterPosition
            notifyItemChanged(position)
            notifyItemChanged(lastSelectedItem)
        }
        if (selectedItem == position) {
            holder.categoryText.setTextColor(Color.parseColor("#FD3A69"))
            holder.container.setBackgroundResource(R.drawable.selected_category_bc)
        } else {
            holder.categoryText.setTextColor(Color.parseColor("#C3C4C9"))
            holder.container.setBackgroundResource(R.drawable.category_bc)
        }
        lastSelectedItem = selectedItem
    }


}

class CategoryViewHolder(item: View): RecyclerView.ViewHolder(item) {
    val categoryText = item.findViewById<TextView>(R.id.category_text)
    val container = item.findViewById<ViewGroup>(R.id.rv_item)
}