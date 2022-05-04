package com.gofootball.football.ui.fixture

import com.gofootball.football.model.Match
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gofootball.football.R
import com.gofootball.football.databinding.ListItemMatchLayoutBinding


class MatchAdapter(val fixtureList:List<Match>, val onItemClick:MatchClickListener): RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {


    class MatchViewHolder(var view: ListItemMatchLayoutBinding): RecyclerView.ViewHolder(view.root) {


        fun bind(match: Match, onItemClick: MatchClickListener){
            view.match=match
            view.clickListener =onItemClick
            view.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ListItemMatchLayoutBinding>(inflate, R.layout.list_item_match_layout,parent,false)
        return MatchViewHolder(view)
    }

    override fun getItemCount(): Int = fixtureList.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.view.match = fixtureList[position]
        holder.bind(fixtureList[position], onItemClick)
    }

    class MatchClickListener(val clickListener: (match: Match) -> Unit){
        fun onClick(match: Match) = clickListener(match)
    }
}