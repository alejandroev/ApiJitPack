package co.dito.abako.apijitpack.data.model.response.service

import com.google.gson.annotations.SerializedName

data class ProgrammingModel(
    @SerializedName("id") val id: Int,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("documento") val documento: Int
)

data class ProgrammingResponse(
    @SerializedName("programaciones") val programaciones: List<ProgrammingModel>,
    @SerializedName("msgId") val msgId: Int,
    @SerializedName("msgStr") val msgStr: String,
)

