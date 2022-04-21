package co.dito.abako.apijitpack.data.model.request.person

import com.google.gson.annotations.SerializedName

data class DllMail(
    @SerializedName("idMail") val idMail: Int,
    @SerializedName("idTipoEmail") val idMailType: Int,
    @SerializedName("mail") val mail: String,
    @SerializedName("predeterminado") val default: Int,
    @SerializedName("operacion") val operation: String
)
