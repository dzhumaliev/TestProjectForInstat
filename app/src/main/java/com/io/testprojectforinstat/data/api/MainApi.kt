package com.io.testprojectforinstat.data.api

import com.io.testprojectforinstat.data.model.headerModel.GetMatchInfo
import com.io.testprojectforinstat.data.model.headerModel.MatchModel
import com.io.testprojectforinstat.data.model.qualityModel.GetVideoModel
import com.io.testprojectforinstat.data.model.qualityModel.QualityModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MainApi {

    @POST("test/data")
    fun getMatchInfo(@Body body: GetMatchInfo): Call<MatchModel>

    @POST("test/video-urls")
    fun getMatchVideo(@Body body: GetVideoModel): Call<ArrayList<QualityModel>>

}