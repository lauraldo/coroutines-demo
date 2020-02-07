package ru.niolasdev.coroutinesdemo.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MissionLinksInfo {

    @SerializedName("mission_patch_small")
    @Expose
    var missionLogo: String? = null

    @SerializedName("flickr_images")
    @Expose
    var images: List<String>? = null

}