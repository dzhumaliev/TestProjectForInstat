package com.io.testprojectforinstat.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes


infix fun ViewGroup.inflate(@LayoutRes id: Int): View {
    return LayoutInflater.from(context).inflate(id, this, false)
}

