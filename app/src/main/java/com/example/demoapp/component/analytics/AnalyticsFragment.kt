package com.example.demoapp.component.analytics

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.demoapp.R
import com.example.demoapp.component.BottomSheetBaseFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup


class AnalyticsFragment : BottomSheetBaseFragment() {

    companion object {
        fun newInstance() = AnalyticsFragment()
    }

    private lateinit var viewModel: AnalyticsViewModel

	override fun getMainLayout(inflater: LayoutInflater, container: ViewGroup?): View {
		return inflater.inflate(R.layout.analytics_fragment, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setTitle(getString(R.string.analytics_type))
		viewModel = ViewModelProvider(this).get(AnalyticsViewModel::class.java)
		setCategoryChips(arrayListOf(
			ChipModel("Face Recognition", R.drawable.ic_baseline_close_24),
			ChipModel("Person", R.drawable.ic_baseline_close_24),
			ChipModel("Vehicle", R.drawable.ic_baseline_close_24),
			ChipModel("Sound", R.drawable.ic_baseline_close_24),
			ChipModel("Tempering", R.drawable.ic_baseline_close_24),
			ChipModel("Crowd", R.drawable.ic_baseline_close_24),
			ChipModel("Fire & Smoke", R.drawable.ic_baseline_close_24),
			ChipModel("Unattached baggage", R.drawable.ic_baseline_close_24),
			ChipModel("Loitering", R.drawable.ic_baseline_close_24)
		))
	}

	private fun setCategoryChips(categories: ArrayList<ChipModel>) {
		for (category in categories) {
			val mChip =
				this.layoutInflater.inflate(R.layout.item_chip_category, null, false) as Chip
			mChip.text = category.chipName
			mChip.chipIcon = activity?.let { ContextCompat.getDrawable(it, category.chipIcon) }
			val paddingDp = TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 10f,
				resources.displayMetrics
			).toInt()
			mChip.setPadding(paddingDp, 0, paddingDp, 0)
			mChip.setOnCheckedChangeListener { _, b -> }
			binding.bottomSheetFragmentHolder.findViewById<ChipGroup>(R.id.chipsPrograms).addView(mChip)
		}
	}
}
