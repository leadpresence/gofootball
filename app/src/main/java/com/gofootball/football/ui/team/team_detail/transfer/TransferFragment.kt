package com.gofootball.football.ui.team.team_detail.transfer

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
import kotlinx.android.synthetic.main.fragment_transfer.*

class TransferFragment : BaseVMFragment<TransferViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transfer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var transferTeamId = arguments?.getInt(Constant.TEAM_ID)
        Toast.makeText(context,"Team Id Transfer :  "+transferTeamId, Toast.LENGTH_SHORT).show()

        viewModel.getAllTransfersOfTeam(transferTeamId!!)
        viewModel.transferList.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvTransfer.layoutManager = LinearLayoutManager(context)
                rvTransfer.adapter = TransferAdapter(it)
            }
        })

    }

    override fun getViewModel(): Class<TransferViewModel> = TransferViewModel::class.java

}
