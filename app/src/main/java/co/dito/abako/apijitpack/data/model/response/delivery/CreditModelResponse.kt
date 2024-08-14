package co.dito.abako.apijitpack.data.model.response.delivery

import com.google.gson.annotations.SerializedName
data class CreditModelResponse(
    @SerializedName("estado") val estado: List<EstadoItem> = emptyList(),
    @SerializedName("idDev") val idDev: Int = 0,
    @SerializedName("nota") val nota: Int = 0,
)
data class EstadoItem(
    @SerializedName("msgId") val msgId: Int = 0,
    @SerializedName("msgStr") val msgStr: String = ""
)