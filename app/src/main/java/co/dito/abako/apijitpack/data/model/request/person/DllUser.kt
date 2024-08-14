package co.dito.abako.apijitpack.data.model.request.person

import com.google.gson.annotations.SerializedName

data class DllUser(
    @SerializedName("usuario") val user: String,
    @SerializedName("contrasena") val password: String
)
