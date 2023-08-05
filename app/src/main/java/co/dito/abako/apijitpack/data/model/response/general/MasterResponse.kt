package co.dito.abako.apijitpack.data.model.response.general

import com.google.gson.annotations.SerializedName

data class MasterResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("descripcion") val description: String,
    @SerializedName("sigla") val initials: String,
    @SerializedName("codigo") val code: String,
    @SerializedName("activo") val active: String,
)
