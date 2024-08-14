package co.dito.abako.apijitpack.data.model.response.firebase

import com.google.gson.annotations.SerializedName

data class LoginBusinessResponse(
    @SerializedName("codigoCodi") val codeCodi: String,
    @SerializedName("soporteActivo") val state: Boolean,
    @SerializedName("nombre") val businessName: String,
    @SerializedName("config") val configurationsApiResponse: List<ConfigurationAPIResponse>,
    @SerializedName("error") val error: String?,
    @SerializedName("motivoSoporteInactivo") val reasonInactive: String?,
    @SerializedName("logoURL") val logoURL: String?
)

data class ConfigurationAPIResponse(
    @SerializedName("codigo") val code: String = "",
    @SerializedName("grupo") val group: String = "",
    @SerializedName("valor") val value: String = "",
    @SerializedName("variable") val variable: String = ""
)
