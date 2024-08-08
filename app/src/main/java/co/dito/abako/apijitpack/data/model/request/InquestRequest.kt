package co.dito.abako.apijitpack.data.model.request

import co.dito.abako.abako.abako.data.model.InquestDll
import com.google.gson.annotations.SerializedName

data class InquestRequest (
    @SerializedName("proceso") val proceso: String = "GET",
    @SerializedName("idPersona") val idPersona: Int = 34,
    @SerializedName("idEmpresa") var idEmpresa: Int = 0,
    @SerializedName("tipo") val tipo: String = "1",
    @SerializedName("fecha") val fecha: String = "2023-03-24",
    @SerializedName("logitud") val logitud: Double = 0.0,
    @SerializedName("latitud") val latitud: Double = 0.0,
    @SerializedName("idEncuesta") val idEncuesta: Int = 0,
    @SerializedName("dll") val dll: List<InquestDll>? = arrayListOf(),
)