package com.example.demoapp.network

import retrofit2.http.GET

interface ApiService {
	@GET("users")
	suspend fun getUsers()
}
