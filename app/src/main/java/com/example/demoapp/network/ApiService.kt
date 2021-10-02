package com.example.demoapp.network

import DemoModel
import com.example.demoapp.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
	@GET("Characters")
	suspend fun fetchCocktailList(): Response<List<DemoModel>>

	@GET("Characters/{id}")
	suspend fun fetchCharacter(@Path("id") id: String): Response<DemoModel>

	companion object {

		var BASE_URL = BuildConfig.API_URL

		fun create(): ApiService {
			val loggingInterceptor = HttpLoggingInterceptor()
			loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

			val retrofit = Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl(BASE_URL)
				.client(
					OkHttpClient.Builder()
						.addInterceptor(loggingInterceptor)
						.build()
				)
				.build()
			return retrofit.create(ApiService::class.java)
		}
	}
}
