package com.example.demoapp.component

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.demoapp.R
import com.example.demoapp.component.analytics.AnalyticsFragment
import com.example.demoapp.component.barchart.BarChartActivity
import com.example.demoapp.component.spinner.CustomSpinnerModel
import com.example.demoapp.component.spinner.SpinnerAdapter
import com.example.demoapp.component.vehicle.VehicleFragment
import com.example.demoapp.databinding.ActivityCommonComponentBinding
import com.example.demoapp.ui.host.HostFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior

class CommonComponentActivity : AppCompatActivity(), CloseBottomSheet {
	private lateinit var binding: ActivityCommonComponentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
		binding = ActivityCommonComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)
		binding.btnBarchart.setOnClickListener {
			val intent = Intent(this, BarChartActivity::class.java)
			startActivity(intent)
		}

		binding.btnBottomsheet1.setOnClickListener {
			openBottomSheet(VehicleFragment())
		}

		binding.btnBottomsheet2.setOnClickListener {
			openBottomSheet(AnalyticsFragment())
		}

		binding.btnOverflow1.setOnClickListener {
			val modelList: ArrayList<CustomSpinnerModel> = arrayListOf()
			modelList.add(CustomSpinnerModel("Create New Group"))
			modelList.add(CustomSpinnerModel("Camera Group(4)"))

			val customDropDownAdapter = SpinnerAdapter(this, modelList)
			binding.categorySpinner.adapter = customDropDownAdapter
		}
    }

	private fun openBottomSheet(fragment: BottomSheetBaseFragment) {
		binding.bsCoordinator.visibility = View.VISIBLE
		binding.sheetView.closeSheet.visibility = View.GONE
		binding.sheetView.lineSeparator.visibility = View.GONE
		val sheetBehavior = BottomSheetBehavior.from(binding.sheetView.bottomSheet)
		sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
		sheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
			override fun onStateChanged(bottomSheet: View, newState: Int) {
				if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
					binding.bsCoordinator.visibility = View.GONE
				} else if (newState == BottomSheetBehavior.STATE_DRAGGING) {
					sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED;
				}
			}

			override fun onSlide(bottomSheet: View, slideOffset: Float) {
			}

		})
		val fragmentManager = supportFragmentManager
		fragment.let {
			fragmentManager.beginTransaction().replace(
				R.id.bottomSheetFragmentHolder,
				it
			).commit()
		}
	}

	override fun closeSheet() {
		val sheetBehavior = BottomSheetBehavior.from(binding.sheetView.bottomSheet)
		sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
		binding.bsCoordinator.visibility = View.GONE
	}
}
