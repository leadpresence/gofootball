package com.gofootball.football.ui.home.topscorer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.gofootball.football.R
import com.gofootball.football.base.BaseVMFragment
import com.gofootball.football.util.CustomSharedPreferences
import kotlinx.android.synthetic.main.fragment_top_scorer.*

class TopScorerFragment : BaseVMFragment<TopScorerViewModel>() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_scorer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var customPreferences = CustomSharedPreferences(activity?.applicationContext!!)
        val leagueId = customPreferences.getCountryId()

        viewModel.getTopScorers(leagueId!!)
        viewModel.topScorerList.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvTopScorers?.layoutManager = LinearLayoutManager(this.context)
                rvTopScorers?.adapter = TopScorerAdapter(it)
            }
        })

        viewModel.loadingTopScorer.observe(viewLifecycleOwner, Observer {
            it.let {
                if (it){
                    rvTopScorers.visibility = View.GONE
                    progressBarTopScorer.visibility = View.VISIBLE
                }else{
                    progressBarTopScorer.visibility = View.GONE
                    rvTopScorers.visibility = View.VISIBLE
                }
            }
        })

    }

    override fun getViewModel(): Class<TopScorerViewModel> = TopScorerViewModel::class.java

}
