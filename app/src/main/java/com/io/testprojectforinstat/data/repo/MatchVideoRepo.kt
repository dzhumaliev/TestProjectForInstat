package com.io.testprojectforinstat.data.repo

import android.util.Log
import com.io.testprojectforinstat.contract.MatchContractView
import com.io.testprojectforinstat.data.api.ApiService
import com.io.testprojectforinstat.data.api.MainApi
import com.io.testprojectforinstat.data.model.qualityModel.GetVideoModel
import com.io.testprojectforinstat.data.model.qualityModel.QualityModel
import retrofit2.Call
import retrofit2.Response

class MatchVideoRepo : MatchContractView.MatchVideoModel {
    private var data: ArrayList<QualityModel>? = null

    override fun getDataVideo(): ArrayList<QualityModel> {
        return data!!
    }

    private var apiclient: MainApi? = null

    init {
        apiclient = ApiService.client.create(MainApi::class.java)
    }

    override fun getVideoModel(
        body: GetVideoModel
    ) {
        val call = apiclient?.getMatchVideo(body)
        call?.enqueue(object : retrofit2.Callback<ArrayList<QualityModel>> {
            override fun onFailure(call: Call<ArrayList<QualityModel>>?, t: Throwable?) {
                Log.d("failure", t.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<QualityModel>>?,
                response: Response<ArrayList<QualityModel>>?
            ) {
                if (response?.isSuccessful!!) {
                    data = response.body()
                }
            }
        })
    }
}