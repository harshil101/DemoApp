package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoapp.databinding.HostActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostActivity : AppCompatActivity() {
	private lateinit var binding: HostActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
		binding = HostActivityBinding.inflate(layoutInflater)
		setContentView(binding.root)
    }
}
