package com.example.demoapp.component.vehicle

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.R
import com.example.demoapp.callback.ItemClickListener
import com.example.demoapp.component.BottomSheetBaseFragment
import com.example.demoapp.databinding.VehicleFragmentBinding
import com.example.demoapp.ui.base.DemoBaseFragment
import com.example.demoapp.ui.host.HostAdapter

class VehicleFragment : BottomSheetBaseFragment(), ItemClickListener {

    companion object {
        fun newInstance() = VehicleFragment()
    }

    private lateinit var viewModel: VehicleViewModel
	private lateinit var adapter: VehicleAdapter

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel = ViewModelProvider(this).get(VehicleViewModel::class.java)
		setTitle("Select Vehicle Type")
		setupUI()
		setUpObserver()
	}

	private fun setupUI() {
		val recyclerView = binding.bottomSheetFragmentHolder.findViewById<RecyclerView>(R.id.radioRecyclerView)
		recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
		adapter = VehicleAdapter(arrayListOf())
		recyclerView.adapter = adapter
	}

	private fun renderList(vehicleList: List<String>) {
		adapter.addData(vehicleList,this)
		adapter.notifyDataSetChanged()
	}

	private fun setUpObserver() {
		viewModel.listOfVehicle.observe(viewLifecycleOwner, Observer {
			renderList(it)
		})
	}

	override fun getMainLayout(inflater: LayoutInflater, container: ViewGroup?): View {
		return inflater.inflate(R.layout.vehicle_fragment, container, false)
	}

	override fun takeId(id: String) {
	}

}
