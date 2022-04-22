package co.dito.abako.apijitpack.data.model.request.person

import com.google.gson.annotations.SerializedName

data class DllPhone(
    @SerializedName("idTelefono") val idPhone: Int,
    @SerializedName("idTipoTelefono") val idPhoneType: Int,
    @SerializedName("indicativoPais") val countryCode: String,
    @SerializedName("indicativoArea") val areaCode: String,
    @SerializedName("telefono") val phone: String,
    @SerializedName("extension") val extension: String,
    @SerializedName("predeterminado") val default: Int,
    @SerializedName("operacion") val operation: String
)
