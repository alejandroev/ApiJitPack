package co.dito.abako.apijitpack.data.model.response.client

import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import com.google.gson.annotations.SerializedName

data class APICreateClientV2Response(
    @SerializedName("idEmpresa") val businessId: Int,
    @SerializedName("mensaje") val message: MessageResponse
)
