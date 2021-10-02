package com.example.demoapp.utils

import com.example.demoapp.network.ApiService

class HostRepository(val id: String) {
	private val apiInterface = ApiService.create()
    suspend fun fetchListOfCocktail() = apiInterface.fetchCocktailList()
	suspend fun fetchCharacter() = apiInterface.fetchCharacter(id)

}
