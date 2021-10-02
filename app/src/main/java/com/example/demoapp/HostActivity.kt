package com.example.demoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.demoapp.databinding.HostActivityBinding

class HostActivity : AppCompatActivity() {
	private lateinit var binding: HostActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
		binding = HostActivityBinding.inflate(layoutInflater)
		setContentView(binding.root)
		val navHostFragment =
			supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
		val navController = navHostFragment.navController
    }
}
