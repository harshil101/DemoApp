package com.example.demoapp.network

import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

	override suspend fun getListOfUsers() {
		TODO("Not yet implemented")
	}

}
