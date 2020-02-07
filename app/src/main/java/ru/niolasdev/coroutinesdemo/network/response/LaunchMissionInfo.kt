package ru.niolasdev.coroutinesdemo.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.niolasdev.coroutinesdemo.core.Convertable
import ru.niolasdev.coroutinesdemo.domain.LaunchMission

class LaunchMissionInfo: Convertable {

    @SerializedName("flight_number")
    @Expose
    var id: Int? = null

    @SerializedName("mission_name")
    @Expose
    var name: String? = null

    @SerializedName("launch_date_unix")
    @Expose
    var launchDate: Long? = null

    @SerializedName("is_tentative")
    @Expose
    var isTentative: Boolean? = null

    @SerializedName("details")
    @Expose
    var details: String? = null

    @SerializedName("links")
    @Expose
    var links: MissionLinksInfo? = null

    override fun convert(): LaunchMission =
        LaunchMission(
            id,
            name,
            launchDate,
            isTentative,
            details,
            links?.missionLogo,
            links?.images
        )
}