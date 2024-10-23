package com.example.networkapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.networkapp.adapter.CategoryRvAdapter
import com.example.networkapp.adapter.PizzaRvAdapter
import com.example.networkapp.adapter.PromoRvAdapter
import com.example.networkapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val api = ApiService()
        val imgList = api.getImages()
        val categories = api.getCategories()
        val pizzaList = api.getPizzaList()

        binding.promoRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.promoRv.adapter = PromoRvAdapter(imgList)

        binding.categoryRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRv.adapter = CategoryRvAdapter(list = categories, categoryClick = { category ->
            binding.pizzaRv.adapter = PizzaRvAdapter(pizzaList.filter { it.category ==  category})
        })

        binding.pizzaRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.pizzaRv.adapter = PizzaRvAdapter(pizzaList)
    }
}