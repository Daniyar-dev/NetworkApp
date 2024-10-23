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
        val pizzaList = listOf(
            Pizza("С грибами", "Шампиньены, ветчина, сыр", 1000,R.drawable.pizza_img, "Пицца"),
            Pizza("С сыром", "Помидоры, колбаса, сыр", 990,R.drawable.pizza_img, "Пицца"),
            Pizza("С курицей", "Курица, зелень, сыр", 1210,R.drawable.pizza_img, "Французкая"),
            Pizza("С грибами", "Шампиньены, ветчина, сыр", 1000,R.drawable.pizza_img, "Макдоналдс"),
            Pizza("Филадельфия", "Зелень, Рис, Рыба", 990,R.drawable.sushi_1, "Суши"),
            Pizza("Жареные", "Курица, ласось, сыр", 1210,R.drawable.sushi_2, "Суши")
        )
        val imgList = listOf(R.drawable.rectangle_38, R.drawable.rectangle_39__1_)
        val categories = listOf("Пицца","Суши","Десерт","Фастфуд","Французкая","Грузинская","Теремок","Макдоналдс",)

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