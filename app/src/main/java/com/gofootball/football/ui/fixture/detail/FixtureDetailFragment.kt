package com.gofootball.football.ui.fixture.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.gofootball.football.R
import com.gofootball.football.ui.fixture.detail.h2h.H2HFragment
import com.gofootball.football.ui.fixture.detail.statistic.StatisticFragment
import com.gofootball.football.util.Constant
import kotlinx.android.synthetic.main.fragment_fixture_detail.*

class FixtureDetailFragment : Fragment() {

    private var bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fixture_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var result = arguments?.getParcelable<Fixture>(Constant.FIXTURE_TEAM_IDS)

        tabLayoutFixture.setupWithViewPager(viewPagerFixture)

        val adapter = fragmentManager?.let { BasePagerAdapter(it) }
        bundle.putParcelable(Constant.FIXTURE_TEAM_IDS, result)
        var h2hFragment = H2HFragment()
        var statisticFragment = StatisticFragment()
        h2hFragment.arguments = bundle
        statisticFragment.arguments = bundle
        adapter?.apply {
            addFragment(h2hFragment, "H2H")
            addFragment(statisticFragment, "STATS")
        }

        viewPagerFixture.adapter = adapter
    }


}
