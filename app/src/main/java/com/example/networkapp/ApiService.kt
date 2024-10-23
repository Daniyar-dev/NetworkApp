package com.example.networkapp


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @POST("posts")
    suspend fun createPost(@Body post: Post): Response<Post>

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

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