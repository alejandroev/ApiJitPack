package co.dito.abako.apijitpack.data.model.response.asesor

import com.google.gson.annotations.SerializedName


data class PermisosAsesorMarca(
    @SerializedName("idMarca") val idMarca: Int,
    @SerializedName("idAsesor") val idAsesor: Int,
    @SerializedName("diaEntrega") val art: Int,
)