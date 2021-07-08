package com.io.testprojectforinstat.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.io.testprojectforinstat.R
import com.io.testprojectforinstat.contract.MatchContractView
import com.io.testprojectforinstat.data.model.headerModel.GetMatchInfo
import com.io.testprojectforinstat.data.model.headerModel.Params
import com.io.testprojectforinstat.data.model.qualityModel.GetVideoModel
import com.io.testprojectforinstat.data.model.qualityModel.QualityModel
import com.io.testprojectforinstat.data.repo.MatchRepo
import com.io.testprojectforinstat.data.repo.MatchVideoRepo
import com.io.testprojectforinstat.presenter.MatchPresenter
import com.io.testprojectforinstat.ui.bottom_frag.VideoBottomFragment
import com.io.testprojectforinstat.ui.recycler.MainAdapter
import com.io.testprojectforinstat.utils.MATCH_INFO
import com.io.testprojectforinstat.utils.P_MATCH_ID
import com.io.testprojectforinstat.utils.P_SPORT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MatchContractView.MatchView {

    private var presenter: MatchPresenter? = null
    private val adapter = MainAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }


    private fun init() {
        presenter = MatchPresenter(MatchRepo(), MatchVideoRepo())
        presenter?.getMatchModel(
            GetMatchInfo(
                MATCH_INFO,
                Params(P_SPORT, P_MATCH_ID.toLong())
            )
        )

        presenter?.getVideoModel(GetVideoModel(P_MATCH_ID.toLong(), P_SPORT))
        initAdapter()
    }

    private fun initAdapter() {
        rv_item.adapter = adapter
        adapter.itemClick = {
            openFrag(it)
        }
    }

    override fun attachView(view: MatchContractView.MatchView) {
        presenter?.attachView(view)
        presenter?.getData().apply {
            tv_title.text = this?.tournament?.nameRus

            tv_team_one.text = (this?.team1?.nameRus + " - " + this?.team1?.score.toString())
            tv_team_two.text = (this?.team1?.score.toString() + " - " + this?.team1?.nameRus)

            tv_date.text = this?.date
        }

        presenter?.getDataVideo().apply {
            Log.e("data", this.toString())
            this?.let { adapter.addData(it) }
        }
    }

    override fun detachView() {
        presenter?.detachView()
    }

    private fun openFrag(itemView: QualityModel) {
        val bundle = Bundle()

        bundle.putString("url", itemView.url)

        val transaction = fragmentManager?.beginTransaction()
        val fragment = VideoBottomFragment()
        fragment.show(supportFragmentManager, fragment.tag)
        fragment.arguments = bundle

        transaction?.addToBackStack(null)
        transaction?.setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction?.commit()

    }

}