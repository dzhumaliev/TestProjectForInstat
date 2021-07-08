package com.io.testprojectforinstat.data.repo

import android.util.Log
import com.io.testprojectforinstat.contract.MatchContractView
import com.io.testprojectforinstat.data.api.ApiService
import com.io.testprojectforinstat.data.api.MainApi
import com.io.testprojectforinstat.data.model.headerModel.GetMatchInfo
import com.io.testprojectforinstat.data.model.headerModel.MatchModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchRepo : MatchContractView.MatchGetModel {

    private var data: MatchModel? = null

    override fun getData(): MatchModel {
        return data!!
    }

    private var apiclient: MainApi? = null

    init {
        apiclient = ApiService.client.create(MainApi::class.java)
    }

    override fun getMatchModel(
        body: GetMatchInfo
    ) {
        val call = apiclient?.getMatchInfo(body)
        call?.enqueue(object : Callback<MatchModel> {
            override fun onFailure(call: Call<MatchModel>?, t: Throwable?) {
                Log.d("failure", t.toString())
            }

            override fun onResponse(call: Call<MatchModel>?, response: Response<MatchModel>?) {
                if (response?.isSuccessful!!) {
                    data = response.body()

                }
            }
        })

    }
}