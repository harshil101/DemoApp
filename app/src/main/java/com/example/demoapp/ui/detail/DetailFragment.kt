package com.example.demoapp.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.demoapp.R
import com.example.demoapp.databinding.DetailFragmentBinding
import com.example.demoapp.ui.base.DemoBaseFragment

class DetailFragment : DemoBaseFragment<DetailFragmentBinding>() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val viewModel: DetailViewModel by viewModels()
	}

	override var _bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DetailFragmentBinding
		= DetailFragmentBinding::inflate

}
