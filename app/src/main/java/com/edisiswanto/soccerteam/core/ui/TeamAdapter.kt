package com.edisiswanto.soccerteam.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edisiswanto.soccerteam.R
import com.edisiswanto.soccerteam.core.domain.model.TeamSoccer
import com.edisiswanto.soccerteam.databinding.ItemListTeamBinding
import java.util.ArrayList

class TeamAdapter: RecyclerView.Adapter<TeamAdapter.ListViewHolder>() {

    private var listData = ArrayList<TeamSoccer>()
    var onItemClick: ((TeamSoccer) -> Unit)? = null

    fun setData(newListData: List<TeamSoccer>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_team, parent, false)
        )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListTeamBinding.bind(itemView)
        fun bind(data: TeamSoccer) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.teamBadge)
                    .into(ivItemImage)
                tvItemName.text = data.name
                tvItemLocation.text = data.country
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}