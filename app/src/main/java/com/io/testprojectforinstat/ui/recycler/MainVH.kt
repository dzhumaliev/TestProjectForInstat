package com.io.testprojectforinstat.ui.recycler

import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.io.testprojectforinstat.R
import com.io.testprojectforinstat.base.adapter.BaseVH
import com.io.testprojectforinstat.data.model.qualityModel.QualityModel

class MainVH(parent: ViewGroup, @LayoutRes id: Int) : BaseVH<QualityModel>(parent, id) {
    private val qualityCount = itemView.findViewById<TextView>(R.id.tv_quality_number)
    private val periodCount = itemView.findViewById<TextView>(R.id.tv_period_game)
    override fun bind(item: QualityModel) {
        qualityCount.text = item.quality.toString()
        periodCount.text = "Тайм № ${item.period}"
    }
}
