package com.edisiswanto.soccerteam.favorite.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.edisiswanto.core.ui.TeamAdapter
import com.edisiswanto.soccerteam.favorite.R
import com.edisiswanto.soccerteam.favorite.databinding.ActivityFavoriteBinding
import com.edisiswanto.soccerteam.favorite.di.favoriteModules
import com.edisiswanto.soccerteam.ui.detailPage.DetailTeamActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbarTitle(getString(R.string.title_favorite))

        loadKoinModules(favoriteModules)

        val teamAdapter = TeamAdapter()
        teamAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailTeamActivity::class.java)
            intent.putExtra(DetailTeamActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteTeam.observe(this, { dataTeam ->
            teamAdapter.setData(dataTeam)
            binding.viewEmpty.root.visibility = if (dataTeam.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvSoccerTeam) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = teamAdapter
        }
    }

    private fun setupToolbarTitle(title: String) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}