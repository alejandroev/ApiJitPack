package co.dito.abako.apijitpack.data.model.request.client

import com.google.gson.annotations.SerializedName

data class APICreateClientV2Request(
    @SerializedName("nombres") val firstNames: String,
    @SerializedName("apellidos") val lastNames: String,
    @SerializedName("identificacion") val identification: String,
    @SerializedName("correo") val email: String,
    @SerializedName("telefono") val phone: String,
    @SerializedName("tipoIdentificacion") val identificationType: String,
    @SerializedName("idZona") val zoneId: Int,
    @SerializedName("idCanal") val channelId: Int,
    @SerializedName("idSegmento") val segmentId: Int,
    @SerializedName("idPrefijo") val prefixId: Int,
    @SerializedName("direccionNumero") val addressNumber: String,
    @SerializedName("direccionIntercepcion") val addressInterception: String,
    @SerializedName("direccionDetalle") val addressDetail: String,
    @SerializedName("idBarrio") val neighborhoodId: Int
)
