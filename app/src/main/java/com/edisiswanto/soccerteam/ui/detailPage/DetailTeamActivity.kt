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
            Glide.with(this@DetailTeamActivity)
                .load(detailTeam.teamBanner)
                .into(binding.ivDetailImage)

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

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}