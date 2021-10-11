package com.example.demoapp.component.barchart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoapp.component.spinner.CustomSpinnerModel
import com.example.demoapp.component.spinner.SpinnerAdapter
import com.example.demoapp.databinding.ActivityBarChartBinding
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.BarData

import com.github.mikephil.charting.data.BarDataSet

import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.components.YAxis

import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.DefaultValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter


class BarChartActivity : AppCompatActivity() {
	private lateinit var binding: ActivityBarChartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
		binding = ActivityBarChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
		showBarChart()
		setUpSpinner()
    }

	private fun setUpSpinner() {
		val modelList: ArrayList<CustomSpinnerModel> = arrayListOf()
		modelList.add(CustomSpinnerModel("Day"))
		modelList.add(CustomSpinnerModel("Week"))
		modelList.add(CustomSpinnerModel("Year"))

		val customDropDownAdapter = SpinnerAdapter(this, modelList)
		binding.calendarSpinner.adapter = customDropDownAdapter
	}
	private fun showBarChart() {
		val valueList = ArrayList<Double>()
		val weekList = ArrayList<String>()
		val entries: ArrayList<BarEntry> = ArrayList()
		val title = "Event Graph"
		weekList.add("Mon")
		weekList.add("Tue")
		weekList.add("Wed")
		weekList.add("Thu")
		weekList.add("Fri")
		weekList.add("Sat")
		weekList.add("Sun")

		//input data
		for (i in 1..7) {
			valueList.add(i * 100.1)
		}

		//fit the data into a bar
		for (i in 0 until valueList.size) {
			val barEntry = BarEntry(i.toFloat(), valueList[i].toFloat())
			entries.add(barEntry)
		}
		val barDataSet = BarDataSet(entries, title)
		val data = BarData(barDataSet)
		data.isHighlightEnabled = false
		val description = Description()
		description.setEnabled(false)

		val xAxis: XAxis = binding.barchartView.xAxis
		xAxis.position = XAxis.XAxisPosition.BOTTOM
		xAxis.setDrawAxisLine(false)
		xAxis.setDrawGridLines(false)
		xAxis.valueFormatter = IndexAxisValueFormatter(weekList)

		val leftAxis: YAxis = binding.barchartView.axisLeft
		leftAxis.setDrawAxisLine(false)

		val rightAxis: YAxis = binding.barchartView.axisRight
		rightAxis.setDrawAxisLine(false)
		rightAxis.setDrawLabels(false)

		binding.barchartView.apply {
			legend.isEnabled = false
			setScaleEnabled(false)
			animateY(1000)
			setDescription(description)
			setData(data)
		}
	}
}
