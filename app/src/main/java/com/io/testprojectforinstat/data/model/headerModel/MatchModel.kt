package com.io.testprojectforinstat.data.model.headerModel

import com.google.gson.annotations.SerializedName

data class MatchModel(
    var tournament: Tournament,
    var date: String,
    var team1: Team1,
    var team2: Team2,
    @SerializedName("stream_status") var streamStatus: String
)

data class Tournament(
    var id: Int,
    @SerializedName("name_eng")var namEng: String,
    @SerializedName("name_rus")var nameRus: String
)

data class Team1(
    var id: Int,
    @SerializedName("name_eng")var namEng: String,
    @SerializedName("name_rus")var nameRus: String,
    var score: Int
)

data class Team2(
    var id: Int,
    @SerializedName("name_eng")var namEng: String,
    @SerializedName("name_rus")var nameRus: String,
    var score: Int

)