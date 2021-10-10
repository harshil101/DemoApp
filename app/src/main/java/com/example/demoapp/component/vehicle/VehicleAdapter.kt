package com.example.demoapp.component.vehicle

import DemoModel
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoapp.callback.ItemClickListener
import com.example.demoapp.databinding.ItemRowLayoutBinding
import com.example.demoapp.databinding.RowRadioViewBinding

class VehicleAdapter(
	private val users: ArrayList<String>
) : RecyclerView.Adapter<VehicleAdapter.ViewHolder>() {
	private lateinit var itemClickListener: ItemClickListener
	private var lastSelectedPosition = -1
	inner class ViewHolder(val binding: RowRadioViewBinding) :
		RecyclerView.ViewHolder(binding.root) {
	}

	fun addData(list: List<String>, itemClickListener: ItemClickListener) {
		users.addAll(list)
		this.itemClickListener = itemClickListener
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding = RowRadioViewBinding
			.inflate(LayoutInflater.from(parent.context), parent, false)

		return ViewHolder(binding)
	}

	override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
		with(holder) {
			binding.vehicleName.text = users[position]
			binding.radioButton.isChecked = lastSelectedPosition == position
			itemView.setOnClickListener {
				if (position == lastSelectedPosition && !binding.radioButton.isChecked) {
					binding.radioButton.isChecked = false
					lastSelectedPosition = -1
				} else {
					lastSelectedPosition = position
					notifyDataSetChanged()
				}
			}
		}
	}

	override fun getItemCount(): Int {
		return users.size
	}
}
