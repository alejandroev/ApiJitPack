package co.dito.abako.apijitpack.data.model.request.person

import com.google.gson.annotations.SerializedName

data class Rut(
    @SerializedName("dia") val day: Int,
    @SerializedName("orden") val order: Int
)
