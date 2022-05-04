package com.gofootball.football.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.gofootball.football.ui.MainViewModelFactory
import com.gofootball.football.ui.fixture.FixtureViewModel

abstract class BaseVMFragment<VM: ViewModel>: Fragment() {

    lateinit var viewModel : VM

    abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

                val viewModelFactory = MainViewModelFactory(requireActivity(), requireActivity().application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModel())
//        viewModel = ViewModelProviders.of(this).get(getViewModel())
    }

}