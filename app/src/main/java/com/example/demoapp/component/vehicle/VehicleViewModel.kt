package com.example.demoapp.component.vehicle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VehicleViewModel : ViewModel() {

	val listOfVehicle = MutableLiveData<List<String>>()

	init {
	    getListOfVehicle()
	}

	private fun getListOfVehicle() {
		val list = arrayListOf<String>()
		list.add("Bike")
		list.add("Car")
		list.add("Ship")
		list.add("Train")
		list.add("Bus")
		list.add("Truck")
		listOfVehicle.value = list
	}
}
