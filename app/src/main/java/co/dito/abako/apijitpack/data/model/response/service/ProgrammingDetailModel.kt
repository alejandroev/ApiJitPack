package co.dito.abako.apijitpack.data.model.response.service

import com.google.gson.annotations.SerializedName

data class ProgrammingDetailResponse(
    @SerializedName("detalle") val detailModel: DetailModel = DetailModel(),
    @SerializedName("msgId") val msgId: Int,
    @SerializedName("msgStr") val msgStr: String,
)

data class DetailModel(
    @SerializedName("servicios") val servicios: List<Servicio> = emptyList(),
    @SerializedName("clientes") val clientes: List<Cliente> = emptyList(),
    @SerializedName("canales") val canales: List<Canal> = emptyList(),
    @SerializedName("zonas") val zonas: List<Zona> = emptyList(),
    @SerializedName("asesores") val asesores: List<Asesor> = emptyList(),
    @SerializedName("tipoProgramaciones") val tipoProgramaciones: List<TipoProgramacion> = emptyList()
)

data class Servicio(
    @SerializedName("idEmpresa") val idEmpresa: Int,
    @SerializedName("idAssr") val idAssr: Int,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("observacion") val observacion: String,
    @SerializedName("idTipo") val idTipo: Int,
    @SerializedName("cantidad") val cantidad: Int,
    @SerializedName("tiempo") val tiempo: Int,
    @SerializedName("orden") val orden: Int
)

data class Cliente(
    @SerializedName("idEmp") val idEmp: Int,
    @SerializedName("rzScl") val rzScl: String,
    @SerializedName("nmbCmn") val nmbCmn: String,
    @SerializedName("idnt") val idnt: String,
    @SerializedName("cod") val cod: String,
    @SerializedName("dir") val dir: String,
    @SerializedName("tel") val tel: String,
    @SerializedName("ultServ") val ultServ: String,
    @SerializedName("cnto") val cnto: String,
    @SerializedName("idCnl") val idCnl: Int,
    @SerializedName("idSeg") val idSeg: Int,
    @SerializedName("idZn") val idZn: Int,
    @SerializedName("lon") val lon: Double,
    @SerializedName("lat") val lat: Double
)

data class Canal(
    @SerializedName("idCnl") val idCnl: Int,
    @SerializedName("cnl") val cnl: String
)

data class Zona(
    @SerializedName("idZn") val idZn: Int,
    @SerializedName("zn") val zn: String
)

data class Asesor(
    @SerializedName("idAssr") val idAssr: Int,
    @SerializedName("assr") val assr: String,
    @SerializedName("tlAssr") val tlAssr: String
)

data class TipoProgramacion(
    @SerializedName("idTipo") val idTipo: Int,
    @SerializedName("descripcion") val descripcion: String
)
