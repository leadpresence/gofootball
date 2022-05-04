package com.gofootball.football.ui.fixture.detail.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.gofootball.football.R
import com.gofootball.football.base.BaseFragment
import com.gofootball.football.databinding.FragmentStatisticBinding
import com.gofootball.football.model.fixture.Fixture
import com.gofootball.football.util.Constant
import kotlinx.android.synthetic.main.fragment_fixture.*
import kotlinx.android.synthetic.main.fragment_statistic.*

class StatisticFragment : BaseFragment<FragmentStatisticBinding, StatisticViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var fixtureIds = arguments?.getParcelable<Fixture>(Constant.FIXTURE_TEAM_IDS)

        viewModel.getFixtureStatistics(fixtureIds?.fixtureİd!!)
        viewModel.fixtureStatic.observe(viewLifecycleOwner, Observer {
            it?.let {
                dataBinding.statistic = it
                dataBinding.pbSOGHome.max = it.shotsOnGoal.home.toInt()+it.shotsOnGoal.away.toInt()
                dataBinding.pbSOGAway.max = it.shotsOnGoal.home.toInt()+it.shotsOnGoal.away.toInt()
                dataBinding.pbSOGHome.progress = it.shotsOnGoal.home.toInt()
                dataBinding.pbSOGAway.progress = it.shotsOnGoal.away.toInt()

                dataBinding.pbOffGHome.max = it.shotsOffGoal.home.toInt()+it.shotsOffGoal.away.toInt()
                dataBinding.pbOffGAway.max = it.shotsOffGoal.home.toInt()+it.shotsOffGoal.away.toInt()
                dataBinding.pbOffGHome.progress = it.shotsOffGoal.home.toInt()
                dataBinding.pbOffGAway.progress = it.shotsOffGoal.away.toInt()

            }
        })

    }

    override fun getResourceLayout(): Int = R.layout.fragment_statistic

    override fun getViewModel(): Class<StatisticViewModel> = StatisticViewModel::class.java

}
