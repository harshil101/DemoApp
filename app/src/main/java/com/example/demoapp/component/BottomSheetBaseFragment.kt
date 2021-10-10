package com.example.demoapp.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demoapp.databinding.BottomSheetViewBinding
import com.example.demoapp.ui.base.DemoBaseFragment

interface CloseBottomSheet {
	fun closeSheet()
}

abstract class BottomSheetBaseFragment: DemoBaseFragment<BottomSheetViewBinding>() {
	protected var closeBottomSheet: CloseBottomSheet? = null
	override var _bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> BottomSheetViewBinding
		 = BottomSheetViewBinding::inflate

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		super.onCreateView(inflater, container, savedInstanceState)
		binding.bottomSheetFragmentHolder.addView(getMainLayout(inflater, container))
		return binding.root
	}

	abstract fun getMainLayout(inflater: LayoutInflater, container: ViewGroup?): View

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		handleClickEvent()
	}

	fun setTitle(title: String) {
		binding.title.text = title
	}

	private fun handleClickEvent() {
		binding.closeSheet.setOnClickListener {
			closeBottomSheet?.closeSheet()
		}
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		if (activity is CloseBottomSheet) {
			closeBottomSheet = activity as CloseBottomSheet
		}
	}

	override fun onDetach() {
		super.onDetach()
		closeBottomSheet = null
	}
}
