package com.edisiswanto.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamSoccer(

	val idTeam: String,
	val name: String,
	val league: String,
	val league2: String,
	val league3: String,
	val sport: String,
	val country: String,
	val description: String,
	val teamBadge: String,
	val teamJersey: String,
	val teamLogo: String,
	val teamBanner: String,
	val stadium: String,
	val stadiumThumb: String,
	val stadiumLocation: String,
	val isFavorite: Boolean
) : Parcelable
