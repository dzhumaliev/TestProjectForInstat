package com.io.testprojectforinstat.contract

import com.io.testprojectforinstat.data.model.headerModel.GetMatchInfo
import com.io.testprojectforinstat.data.model.headerModel.MatchModel
import com.io.testprojectforinstat.data.model.qualityModel.GetVideoModel
import com.io.testprojectforinstat.data.model.qualityModel.QualityModel


interface MatchContractView {

    interface MatchGetModel {
        fun getMatchModel(body: GetMatchInfo)
        fun getData(): MatchModel
    }

    interface MatchView {
        fun attachView(view: MatchView)
        fun detachView()
    }

    interface MatchVideoModel {
        fun getVideoModel(body: GetVideoModel)
        fun getDataVideo(): ArrayList<QualityModel>
    }
}