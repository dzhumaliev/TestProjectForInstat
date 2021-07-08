package com.io.testprojectforinstat.ui.recycler

import android.view.ViewGroup
import com.io.testprojectforinstat.R
import com.io.testprojectforinstat.base.adapter.BaseAdapter
import com.io.testprojectforinstat.data.model.qualityModel.QualityModel

class MainAdapter : BaseAdapter<QualityModel, MainVH>() {
    var itemClick: (QualityModel) -> Unit = { }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVH {
        val holder = MainVH(parent, R.layout.item_list)
        holder.itemView.setOnClickListener { itemClick(items[holder.adapterPosition]) }
        return holder
    }
}