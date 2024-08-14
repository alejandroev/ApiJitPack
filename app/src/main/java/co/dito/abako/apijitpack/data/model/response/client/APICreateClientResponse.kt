package co.dito.abako.apijitpack.data.model.response.client

import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import com.google.gson.annotations.SerializedName

data class APICreateClientResponse(
    @SerializedName("idCliente") val clientId: Int,
    @SerializedName("idEmpresaNueva") val newBusinessId: Int,
    @SerializedName("estado") val states: List<MessageResponse>,
) : MessageResponse()