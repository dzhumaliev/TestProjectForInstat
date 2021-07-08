package com.io.testprojectforinstat.data.model.headerModel

import com.google.gson.annotations.SerializedName

data class GetMatchInfo(
    var proc: String,
    var params: Params
)

data class Params(
    @SerializedName("_p_sport") var pSport: Int,
    @SerializedName("_p_match_id") var pMatchId: Long
)