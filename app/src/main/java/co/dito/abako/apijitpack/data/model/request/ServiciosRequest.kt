package co.dito.abako.apijitpack.data.model.request

import com.google.gson.annotations.SerializedName


data class ServiciosRequest(
    @SerializedName("id") val id: Int,
    @SerializedName("idUsuario") val idUsuario: Int,
    @SerializedName("dll") val dll: List<DllItem>
)

data class DllItem(
    @SerializedName("idTipoProgramacion") val idTipoProgramacion: Int,
    @SerializedName("novedad") val novedad: String
)


data class MessageServiceResponse(
    @SerializedName("mensaje")  val mensaje: Mensaje
)

data class Mensaje(
    @SerializedName("msgId") val msgId: Int,
    @SerializedName("msgStr") val msgStr: String
)