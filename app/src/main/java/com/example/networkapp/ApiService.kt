package com.example.networkapp


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class ApiService {
    fun getPizzaList(): List<Pizza> {
        val pizzaList = listOf(
            Pizza("С грибами", "Шампиньены, ветчина, сыр", 1000,R.drawable.pizza_img, "Пицца"),
            Pizza("С сыром", "Помидоры, колбаса, сыр", 990,R.drawable.pizza_img, "Пицца"),
            Pizza("С курицей", "Курица, зелень, сыр", 1210,R.drawable.pizza_img, "Французкая"),
            Pizza("С грибами", "Шампиньены, ветчина, сыр", 1000,R.drawable.pizza_img, "Макдоналдс"),
            Pizza("Филадельфия", "Зелень, Рис, Рыба", 990,R.drawable.sushi_1, "Суши"),
            Pizza("Жареные", "Курица, ласось, сыр", 1210,R.drawable.sushi_2, "Суши")
        )
        return pizzaList
    }
    fun getCategories(): List<String> {
        val categories = listOf("Пицца","Суши","Десерт","Фастфуд","Французкая","Грузинская","Теремок","Макдоналдс",)
        return categories
    }
    fun getImages(): List<Int> {
        val imgList = listOf(R.drawable.rectangle_38, R.drawable.rectangle_39__1_)
        return imgList
    }
}

data class User(
    val id: Int,
    val name: String,
    val email: String
)


data class Post(
    val id: Int? = null,
    val title: String,
    val body: String,
    val userId: Int
)