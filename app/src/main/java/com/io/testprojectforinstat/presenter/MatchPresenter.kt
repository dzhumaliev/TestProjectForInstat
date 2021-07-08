package com.io.testprojectforinstat.presenter

import com.io.testprojectforinstat.contract.MatchContractView
import com.io.testprojectforinstat.data.model.headerModel.GetMatchInfo
import com.io.testprojectforinstat.data.model.headerModel.MatchModel
import com.io.testprojectforinstat.data.model.qualityModel.GetVideoModel
import com.io.testprojectforinstat.data.model.qualityModel.QualityModel
import com.io.testprojectforinstat.data.repo.MatchRepo
import com.io.testprojectforinstat.data.repo.MatchVideoRepo

class MatchPresenter(
    private val matchRepository: MatchRepo,
    private val videoRepo: MatchVideoRepo
) :
    MatchContractView.MatchView, MatchContractView.MatchGetModel,
    MatchContractView.MatchVideoModel {

    var homeView: MatchContractView.MatchView? = null

    override fun getMatchModel(body: GetMatchInfo) {
        return matchRepository.getMatchModel(body)
    }

    override fun getData(): MatchModel {
        return matchRepository.getData()
    }

    override fun getVideoModel(
        body: GetVideoModel
    ) {
        return videoRepo.getVideoModel(body)
    }

    override fun getDataVideo(): ArrayList<QualityModel> {
        return videoRepo.getDataVideo()
    }

    override fun attachView(view: MatchContractView.MatchView) {
        homeView = view
    }

    override fun detachView() {
        homeView = null
    }


}