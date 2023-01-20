package co.dito.abako.apijitpack.data.model.request.firebase

import com.google.gson.annotations.SerializedName

data class LoginBusinessRequest(
    @SerializedName("negocio") val business: String,
    @SerializedName("contrasena") val password: String
)
