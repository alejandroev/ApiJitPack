package co.dito.abako.apijitpack.data.model.request.person

import com.google.gson.annotations.SerializedName

data class UserCompany(
    @SerializedName("idEmpresa") val idCompany: Int,
    @SerializedName("identificacion") val identification: Int,
    @SerializedName("razon_Social") val socialReason: Int,
    @SerializedName("nombre_Comun") val commonName: String
)
