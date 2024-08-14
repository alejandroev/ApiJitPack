package co.dito.abako.apijitpack.data.model.request.client

import com.google.gson.annotations.SerializedName

data class SetAbakoClientRequest(
    @SerializedName("idEmpresa") val companyId: Int,
    @SerializedName("esCreadoAbakoCliente") val isCreatedByAbakoClient: Boolean = true
)
