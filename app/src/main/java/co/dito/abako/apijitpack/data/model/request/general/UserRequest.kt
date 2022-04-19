package co.dito.abako.apijitpack.data.model.request.general

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("usuario") val user: String,
    @SerializedName("password") val password: String,
    @SerializedName("esAgente") val agent: Int
)
