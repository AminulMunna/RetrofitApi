package com.example.retrofitapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getAllPosts() : Call<List<Post>>
}