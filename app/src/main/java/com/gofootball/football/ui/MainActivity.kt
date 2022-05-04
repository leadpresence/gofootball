package com.gofootball.football.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gofootball.football.R
import com.gofootball.football.databinding.ActivityMainBinding
import com.gofootball.football.ui.fixture.FixtureViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: FixtureViewModel
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = this.findNavController(R.id.fragment)

        val viewModelFactory = MainViewModelFactory(this, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FixtureViewModel::class.java)

        bottomNavigationView.setupWithNavController(navController)

        binding.lifecycleOwner = this
    }
}
