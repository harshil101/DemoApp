package com.example.demoapp.ui.host

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.demoapp.R
import com.example.demoapp.databinding.HostFragmentBinding
import com.example.demoapp.ui.base.DemoBaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostFragment : DemoBaseFragment<HostFragmentBinding>() {

    companion object {
        fun newInstance() = HostFragment()
    }

    private lateinit var viewModel: HostViewModel

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val viewModel: HostViewModel by viewModels()
	}

	override var _bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> HostFragmentBinding
		= HostFragmentBinding::inflate

}
