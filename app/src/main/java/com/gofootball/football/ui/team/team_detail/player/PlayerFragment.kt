package com.gofootball.football.ui.team.team_detail.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.gofootball.football.R
import com.gofootball.football.base.BaseVMFragment
import com.gofootball.football.util.Constant
import kotlinx.android.synthetic.main.fragment_player.*


class PlayerFragment : BaseVMFragment<PlayerViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var playerTeamId = arguments?.getInt(Constant.TEAM_ID)
        Toast.makeText(context,"Team Id Player :  "+playerTeamId, Toast.LENGTH_SHORT).show()

        viewModel.getAllPlayersOfTeam(playerTeamId!!)
        viewModel.playerList.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvPlayer.layoutManager = LinearLayoutManager(context)
                rvPlayer.adapter = PlayerAdapter(it){
                    Toast.makeText(requireContext(), "Tıklandı player item ", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.loadingPlayer.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    rvPlayer.visibility = View.GONE
                    progressBarPlayer.visibility = View.VISIBLE
                }else{
                    rvPlayer.visibility = View.VISIBLE
                    progressBarPlayer.visibility = View.GONE
                }
            }
        })

    }

    override fun getViewModel(): Class<PlayerViewModel> = PlayerViewModel::class.java

}
