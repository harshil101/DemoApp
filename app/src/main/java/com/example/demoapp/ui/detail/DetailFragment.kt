package com.example.demoapp.ui.detail

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.demoapp.R
import com.example.demoapp.databinding.DetailFragmentBinding
import com.example.demoapp.ui.base.DemoBaseFragment
import com.example.demoapp.utils.Status
import com.example.demoapp.utils.ViewModelFactory

class DetailFragment : DemoBaseFragment<DetailFragmentBinding>() {
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val bundle = arguments
		if (bundle == null) {
			Log.e("Confirmation", "ConfirmationFragment did not receive traveler information")
			return
		}
		val args = DetailFragmentArgs.fromBundle(bundle)
		val viewModel: DetailViewModel by viewModels { ViewModelFactory(args.id) }
		viewModel.userLiveData.observe(viewLifecycleOwner, Observer {
			when (it.status) {
				Status.SUCCESS -> {
					binding.progressDialog.visibility = View.GONE
					it.data?.let {
						with(binding) {
							tvName.text = it.firstName
							tvFullDetail.text = it.fullName
							Glide.with(displayPic.context)
								.load(it.imageUrl)
								.into(displayPic)
						}
					}
				}
				Status.LOADING -> {
					binding.progressDialog.visibility = View.VISIBLE
				}
				Status.ERROR -> {
					binding.progressDialog.visibility = View.GONE
					Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
				}
			}
		}
		)
	}

	override var _bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DetailFragmentBinding =
		DetailFragmentBinding::inflate

}
