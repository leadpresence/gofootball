package com.gofootball.football.ui.fixture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.gofootball.football.R
import com.gofootball.football.base.BaseVMFragment
import com.gofootball.football.databinding.FragmentFixtureBinding
import com.gofootball.football.model.Match
import com.gofootball.football.ui.MainViewModelFactory
import com.gofootball.football.util.CustomSharedPreferences
import kotlinx.android.synthetic.main.fragment_fixture.*


//class FixtureFragment :  Fragment() {
//    private lateinit var binding: FragmentFixtureBinding
//    private lateinit var fixtureViewModel: FixtureViewModel
//    private lateinit var navController: NavController
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        binding =
//            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_fixture, container, false)
//        val viewModelFactory =
//            MainViewModelFactory(requireActivity(), requireActivity().application)
//
//        fixtureViewModel =
//            ViewModelProvider(requireActivity(), viewModelFactory).get(FixtureViewModel::class.java)
//
//        var customPreferences = CustomSharedPreferences(activity?.applicationContext!!)
//        val leagueId = customPreferences.getCountryId()
//
//        fixtureViewModel.getAllMatchFixture()
//
//
//
////            binding.viewModel = viewModel
//        binding.lifecycleOwner = requireActivity()
//
//        fixtureViewModel.loadingFixture.value=true
//        fixtureViewModel.matchesList.observe(requireActivity(),{})
//        return binding.root
//
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }
//
//}


class FixtureFragment : BaseVMFragment<FixtureViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fixture, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var customPreferences = CustomSharedPreferences(activity?.applicationContext!!)
        val leagueId = customPreferences.getCountryId()


        viewModel.getAllMatchFixture()

        viewModel.matchesList.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvFixture.layoutManager = LinearLayoutManager(context)
                rvFixture.adapter = MatchAdapter(it,
                    MatchAdapter.MatchClickListener { match ->
                        {}
                    })
            }
        })

        viewModel.loadingFixture.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it) {
                    rvFixture.visibility = View.GONE
                    progressFixture.visibility = View.VISIBLE
                } else {
                    rvFixture.visibility = View.VISIBLE
                    progressFixture.visibility = View.GONE
                }
            }
        })
    }
    override fun getViewModel(): Class<FixtureViewModel> = FixtureViewModel::class.java

}