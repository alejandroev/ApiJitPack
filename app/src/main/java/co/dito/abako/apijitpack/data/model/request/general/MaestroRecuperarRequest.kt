package co.dito.abako.apijitpack.data.model.request.general

import com.google.gson.annotations.SerializedName

/**
 * Body para el endpoint de negocio `POST Maestros/Recuperar`.
 */
data class MaestroRecuperarRequest(
    @SerializedName("tipoMaestro") val tipoMaestro: String,
    @SerializedName("idPadre") val idPadre: Long = 0L,
    @SerializedName("soloActivo") val soloActivo: Boolean = true,
)
