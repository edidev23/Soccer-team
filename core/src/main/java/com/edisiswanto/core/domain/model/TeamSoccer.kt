package com.edisiswanto.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamSoccer(

	val idTeam: String,
	val name: String,
	val league: String,
	val sport: String,
	val country: String,
	val description: String,
	val teamBadge: String,
	val teamJersey: String,
	val teamLogo: String,
	val teamBanner: String,
	val isFavorite: Boolean
) : Parcelable
