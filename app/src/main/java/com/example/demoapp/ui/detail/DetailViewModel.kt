package com.example.demoapp.ui.detail

import DemoModel
import android.annotation.SuppressLint
import androidx.lifecycle.*
import com.example.demoapp.utils.ConnectivityHelper
import com.example.demoapp.utils.HostRepository
import com.example.demoapp.utils.Resource
import kotlinx.coroutines.launch

class DetailViewModel(id: String) : ViewModel(){
	@SuppressLint("StaticFieldLeak")
	private val userData = MutableLiveData<Resource<DemoModel>>()
	private var hostRepository: HostRepository = HostRepository(id)
	val userLiveData: LiveData<Resource<DemoModel>>
		get() = userData

	init {
		fetchChar()
	}

	private fun fetchChar() {
		viewModelScope.launch {
			userData.postValue(Resource.loading(null))
				hostRepository.fetchCharacter().let {
					if (it.isSuccessful) {
						userData.postValue(Resource.success(it.body()))
					} else userData.postValue(Resource.error(it.errorBody().toString(), null))
				}
		}
	}
}
