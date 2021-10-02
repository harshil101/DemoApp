package com.example.demoapp.ui.host

import DemoModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapp.R
import com.example.demoapp.callback.ItemClickListener
import com.example.demoapp.databinding.HostFragmentBinding
import com.example.demoapp.ui.base.DemoBaseFragment
import com.example.demoapp.utils.Status

class HostFragment : DemoBaseFragment<HostFragmentBinding>(), ItemClickListener {

	private val viewModel: HostViewModel by viewModels()
	private lateinit var adapter: HostAdapter
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setupUI()
		setupObserver()
	}

	private fun setupUI() {
		binding.recyclerView.layoutManager = LinearLayoutManager(activity)
		adapter = HostAdapter(arrayListOf())
		binding.recyclerView.addItemDecoration(
			DividerItemDecoration(
				binding.recyclerView.context,
				(binding.recyclerView.layoutManager as LinearLayoutManager).orientation
			)
		)
		binding.recyclerView.adapter = adapter
	}

	private fun setupObserver() {
		viewModel.cockTailLiveData.observe(viewLifecycleOwner, Observer {
			when (it.status) {
				Status.SUCCESS -> {
					binding.progressBar.visibility = View.GONE
					it.data?.let { users -> renderList(users) }
					binding.recyclerView.visibility = View.VISIBLE
				}
				Status.LOADING -> {
					binding.progressBar.visibility = View.VISIBLE
					binding.recyclerView.visibility = View.GONE
				}
				Status.ERROR -> {
					binding.progressBar.visibility = View.GONE
					Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
				}
			}
		})
	}

	private fun renderList(users: List<DemoModel>) {
		adapter.addData(users,this)
		adapter.notifyDataSetChanged()
	}

	override var _bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> HostFragmentBinding =
		HostFragmentBinding::inflate

	override fun takeId(id: String) {
		val navController = activity?.let {
			Navigation.findNavController(
				it,
				R.id.nav_host_fragment
			)
		}
		val direction = HostFragmentDirections.actionHostFragmentToDetailFragment(id)
		navController?.navigate(direction)
	}

}
