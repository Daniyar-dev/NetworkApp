package com.example.networkapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.networkapp.Pizza
import com.example.networkapp.R

class PizzaRvAdapter (private val list: List<Pizza>): RecyclerView.Adapter<PizzaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_pizza, parent, false)
        return PizzaViewHolder(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = list[position]
        holder.image.setImageResource(pizza.image)
        holder.name.text = pizza.name
        holder.description.text = pizza.description
        holder.price.text = "От ${pizza.price} тг"
    }
}


class PizzaViewHolder(item: View): RecyclerView.ViewHolder(item) {
    val image = item.findViewById<ImageView>(R.id.pizzaImg)
    val name = item.findViewById<TextView>(R.id.name)
    val description = item.findViewById<TextView>(R.id.descText)
    val price = item.findViewById<TextView>(R.id.priceText)
}