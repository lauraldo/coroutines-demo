package ru.niolasdev.coroutinesdemo.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LaunchMission(
    val id: Int?,
    val name: String?,
    val launchDate: Long?,
    val isTentative: Boolean?,
    val details: String?,
    val iconUrl: String?,
    val photoUrls: List<String>?): Parcelable