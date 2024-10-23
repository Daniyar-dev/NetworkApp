package com.example.networkapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.networkapp.R

class PromoRvAdapter(private val list: List<Int>): RecyclerView.Adapter<PromoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_promo, parent, false)
        return PromoViewHolder(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.promoImg.setImageResource(list[position])
    }


}

class PromoViewHolder(item: View): RecyclerView.ViewHolder(item) {
    val promoImg = item.findViewById<ImageView>(R.id.promoImg)
}