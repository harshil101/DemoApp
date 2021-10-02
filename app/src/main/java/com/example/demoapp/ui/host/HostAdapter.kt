package com.example.demoapp.ui.host

import DemoModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoapp.callback.ItemClickListener
import com.example.demoapp.databinding.ItemRowLayoutBinding

class HostAdapter(
	private val users: ArrayList<DemoModel>
) : RecyclerView.Adapter<HostAdapter.ViewHolder>() {
	private lateinit var itemClickListener: ItemClickListener

	inner class ViewHolder(val binding: ItemRowLayoutBinding) :
		RecyclerView.ViewHolder(binding.root) {
	}

	fun addData(list: List<DemoModel>, itemClickListener: ItemClickListener) {
		users.addAll(list)
		this.itemClickListener = itemClickListener
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding = ItemRowLayoutBinding
			.inflate(LayoutInflater.from(parent.context), parent, false)

		return ViewHolder(binding)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		with(holder) {
			binding.tvBottle.text = users[position].firstName
			binding.tvDetail.text = users[position].fullName
			Glide.with(binding.displayImage.context)
				.load(users[position].imageUrl)
				.into(binding.displayImage)
			itemView.setOnClickListener {
				itemClickListener.takeId(users[position].id.toString())
			}
		}
	}

	override fun getItemCount(): Int {
		return users.size
	}
}
