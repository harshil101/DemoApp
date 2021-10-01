package com.example.demoapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class DemoBaseFragment<VB: ViewBinding> : Fragment() {
	private var _binding: ViewBinding? = null
	abstract var _bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

	val binding: VB
		get() = _binding as VB

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = _bindingInflater.invoke(inflater, container, false)
		return (requireNotNull(_binding).root)
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}
