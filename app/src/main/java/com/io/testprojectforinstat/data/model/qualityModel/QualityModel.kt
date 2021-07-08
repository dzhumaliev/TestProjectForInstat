package com.io.testprojectforinstat.data.model.qualityModel

import com.google.gson.annotations.SerializedName

data class QualityModel(
    var name: String,
    @SerializedName("match_id") var matchId: Long,
    var period: Int,
    @SerializedName("server_id") var serverId: Int,
    var quality: Int,
    var folder: Int,
    @SerializedName("video_type") var videoType: String,
    var abc: String,
    @SerializedName("start_ms") var startMs: Long,
    var checksum: Long,
    var size: Long,
    @SerializedName("abc_type") var abcType: String,
    var duration: Long,
    var fps: Int,
    @SerializedName("url_root") var urlRoot: String,
    var url: String
)