package co.dito.abako.apijitpack.data.model.request

import com.google.gson.annotations.SerializedName

data class InquestDll (
    @SerializedName("etiqueta") val etiqueta: String = "",
    @SerializedName("respuesta") var respuesta: String = "",
)