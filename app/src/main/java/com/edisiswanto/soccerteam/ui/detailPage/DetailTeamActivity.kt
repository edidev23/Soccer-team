package com.edisiswanto.soccerteam.ui.detailPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.edisiswanto.soccerteam.R
import com.edisiswanto.core.domain.model.TeamSoccer
import com.edisiswanto.soccerteam.databinding.ActivityDetailTeamBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailTeamActivity : AppCompatActivity() {
    private val detailTeamViewModel: DetailTeamViewModel by viewModel()
    private lateinit var binding: ActivityDetailTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailTeam = intent.getParcelableExtra<TeamSoccer>(EXTRA_DATA)
        showDetailTeam(detailTeam)
    }

    private fun showDetailTeam(detailTeam: TeamSoccer?) {
        detailTeam?.let {
            supportActionBar?.title = detailTeam.name
            binding.content.tvDetailDescription.text = detailTeam.description
            binding.content.title.text = detailTeam.stadium
            binding.content.location.text = detailTeam.stadiumLocation
            binding.content.tvLeague1.text = detailTeam.league
            binding.content.tvLeague2.text = detailTeam.league2
            binding.content.tvLeague3.text = detailTeam.league3

            Glide.with(this@DetailTeamActivity)
                .load(detailTeam.stadiumThumb)
                .into(binding.ivDetailImage)

            Glide.with(this@DetailTeamActivity)
                .load(detailTeam.teamBadge)
                .into(binding.content.ivBadge)

            Glide.with(this@DetailTeamActivity)
                .load(detailTeam.teamJersey)
                .into(binding.content.ivJersey)

            Glide.with(this@DetailTeamActivity)
                .load(detailTeam.teamLogo)
                .into(binding.content.ivLogo)

            var statusFavorite = detailTeam.isFavorite
            setStatusFavorite(statusFavorite)

            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTeamViewModel.setFavoriteTeam(detailTeam, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_24))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_24))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}