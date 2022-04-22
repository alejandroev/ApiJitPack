package co.dito.abako.apijitpack.data.model.response.general

import com.google.gson.annotations.SerializedName

data class JsonCompress(
    @SerializedName("Content") val content : String
)