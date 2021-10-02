package com.example.demoapp.ui.host

import DemoModel
import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.*
import com.example.demoapp.utils.ConnectivityHelper
import com.example.demoapp.utils.HostRepository
import com.example.demoapp.utils.Resource
import com.google.gson.Gson
import kotlinx.coroutines.launch

class HostViewModel(application: Application) : AndroidViewModel(application)
{
	@SuppressLint("StaticFieldLeak")
	private val context = getApplication<Application>().applicationContext
	private val cocktailData = MutableLiveData<Resource<List<DemoModel>>>()
	private val networkHelper: ConnectivityHelper = ConnectivityHelper(context)
	private val hostRepository: HostRepository = HostRepository("")
	val cockTailLiveData: LiveData<Resource<List<DemoModel>>>
		get() = cocktailData

	init {
		fetchUsers()
	}

	private fun fetchUsers() {
		viewModelScope.launch {
			cocktailData.postValue(Resource.loading(null))
			if (networkHelper.isNetworkConnected()) {
				hostRepository.fetchListOfCocktail().let {
					if (it.isSuccessful) {
						cocktailData.postValue(Resource.success(it.body()))
					} else cocktailData.postValue(Resource.error(it.errorBody().toString(), null))
				}
			} else cocktailData.postValue(Resource.error("No internet connection", null))
		}
	}
}
