package com.io.testprojectforinstat.data.model.qualityModel

import com.google.gson.annotations.SerializedName

data class GetVideoModel(
    @SerializedName("match_id") var matchId: Long,
    @SerializedName("sport_id") var sportId: Int
)
