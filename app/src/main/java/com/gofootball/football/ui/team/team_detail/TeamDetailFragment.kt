package com.gofootball.football.ui.team.team_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.gofootball.football.R
import com.gofootball.football.ui.team.team_detail.player.PlayerFragment
import com.gofootball.football.ui.team.team_detail.transfer.TransferFragment
import com.gofootball.football.util.Constant
import kotlinx.android.synthetic.main.fragment_team_detail.*


class TeamDetailFragment : Fragment() {

    private var teamId = 0
    private var bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            teamId = TeamDetailFragmentArgs.fromBundle(it).teamId
        }
        setupIU()
    }

    private fun setupIU(){
        setupViewPager()
        tabLayoutTeam.setupWithViewPager(viewPagerTeam)
    }

    private fun setupViewPager(){
        val adapter = fragmentManager?.let { TeamDetailPagerAdapter(it) }

        bundle.putInt(Constant.TEAM_ID, teamId)

        var playerFragment = PlayerFragment()
        var transferFragment = TransferFragment()
        playerFragment.arguments = bundle
        transferFragment.arguments = bundle

        adapter?.apply {
            addFragment(playerFragment, "Players")
            addFragment(transferFragment, "Transfer")
        }
        viewPagerTeam.adapter = adapter
    }




}
