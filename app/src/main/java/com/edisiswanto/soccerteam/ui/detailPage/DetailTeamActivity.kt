package com.edisiswanto.soccerteam.ui.detailPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edisiswanto.soccerteam.R

class DetailTeamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}