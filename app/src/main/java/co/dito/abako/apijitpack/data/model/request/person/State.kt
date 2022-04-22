package co.dito.abako.apijitpack.data.model.request.person

import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("msgId") val msgId: Int,
    @SerializedName("msgStr") val msgSrt: String
)