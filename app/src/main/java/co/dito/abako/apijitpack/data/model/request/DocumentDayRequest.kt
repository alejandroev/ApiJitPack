package co.dito.abako.apijitpack.data.model.request

import com.google.gson.annotations.SerializedName

data class DocumentDayRequest(
    @SerializedName("fecha") val fecha: String = "",
    @SerializedName("idPersona") val idPersona: Int = 0,
)

data class EncabezadoPedido(
    val idpd: Int,
    val idEmp: Int,
    val ped: String,
    val tp: String,
    val otDcto: Int,
    val obs: String,
    val cnt: Int,
    val usr: Int,
    val fnt: Int,
    val dir: Int,
    val fcent: String,
    val fc: String,
    val fe: String,
    val agn: String,
    val total: Double,
    val rfv: String
)

data class DetallePedido(
    val idpd: Int,
    val idArt: Int,
    val cant: Int,
    val um: String,
    val descu: Double
)

data class DocumentDayResponse(
    val encabezadoPedido: List<EncabezadoPedido>,
    val detallePedido: List<DetallePedido>,
    val msgId: Int,
    @SerializedName("apiStatus") val apiStatus: ApiStatus
)