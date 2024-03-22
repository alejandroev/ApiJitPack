package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.common.converters.DateJsonDeserializeOld
import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * @param deliveryDetail = List of deliveries
 */

data class DeliveryDetailResponse(
    @SerializedName("EntregaDetalle") val deliveryDetail: DeliveryDetailSyncResponse
) : MessageResponseOld()


data class DeliveryDetailResponseApi(
    @SerializedName("entregaDetalle") val deliveryDetail: DeliveryDetail,
    @SerializedName("msgId") val msgId: Int,
    @SerializedName("msgStr") val msgStr: String,
)

data class DeliveryDetail(
    @SerializedName("facturas") val order: List<OrderItem> = emptyList(),
    @SerializedName("clientes") val client: List<Client> = emptyList(),
    @SerializedName("contactos") val contact: List<Contact> = emptyList(),
    @SerializedName("canales") val chanel: List<Channel> = emptyList(),
    @SerializedName("zonas") val zone: List<Zone> = emptyList(),
    @SerializedName("asesores") val advisor: List<Advisor> = emptyList(),
    @SerializedName("articulos") val article: List<Article> = emptyList()
)

data class OrderItem(
    @SerializedName("idPed") val orderId: Int,
    @SerializedName("idVnt") val saleId: Int,
    @SerializedName("fctr") val factor: Int,
    @SerializedName("fc") val fc: Date,
    @SerializedName("idEmp") val employeeId: Int,
    @SerializedName("idAssr") val assessorId: Int,
    @SerializedName("fp") val paymentMethod: Int,
    @SerializedName("otrosValores") val otherValues: Double,
    @SerializedName("idArt") val articleId: Int,
    @SerializedName("cant") val quantity: Int,
    @SerializedName("precio") val price: Double,
    @SerializedName("subtotal") val subtotal: Double,
    @SerializedName("orden") val order: Double
)

data class Client(
    @SerializedName("idEmp") val idEmp: Int,
    @SerializedName("rzScl") val rzScl: String,
    @SerializedName("nmbCmn") val nmbCmn: String,
    @SerializedName("idnt") val idNt: String,
    @SerializedName("cod") val cod: String,
    @SerializedName("idCnl") val idCnl: Int,
    @SerializedName("idSeg") val idSeg: Int,
    @SerializedName("idZn") val idZn: Int,
    @SerializedName("idLP") val idLp: Int,
    @SerializedName("lon") val lon: Double,
    @SerializedName("lat") val lat: Double,
    @SerializedName("fp") val fp: Int,
    @SerializedName("cp") val cp: Double,
    @SerializedName("vncmnt") val vncmnt: Int,
    @SerializedName("frc") val frc: Int,
    @SerializedName("ini") val ini: Int,
    @SerializedName("fcIni") val fcIni: Date,
    @SerializedName("ultVt") val ultVt: Date,
    @SerializedName("fchltmpg") val fchltmpg: Date,
    @SerializedName("ultmpg") val ultmpg: Double,
    @SerializedName("prcs") val prcs: String,
)

data class Contact(
    @SerializedName("idCnto") val id: Int,
    @SerializedName("idEmp") val companyId: Int,
    @SerializedName("nmbr") val name: String,
    @SerializedName("dir") val address: String,
    @SerializedName("idCdd") val cityId: Int,
    @SerializedName("idDir") val directionId: Int,
    @SerializedName("tel") val phone: String,
    @SerializedName("mail") val email: String,
    @SerializedName("pdt") val pdt: Int,
    @SerializedName("tipo") val type: String,
    @SerializedName("prcs") val process: String
)

data class Channel(
    @SerializedName("idCnl") val id: Int,
    @SerializedName("cnl") val name: String
)

data class Zone(
    @SerializedName("idZn") val id: Int,
    @SerializedName("zn") val name: String
)

data class Article(
    @SerializedName("idArt") val id: Int,
    @SerializedName("codArt") val code: String,
    @SerializedName("art") val name: String,
    @SerializedName("idMc") val categoryId: Int,
    @SerializedName("idCt") val subcategoryId: Int,
    @SerializedName("iva") val tax: Double,
    @SerializedName("dsct") val discount: Double,
    @SerializedName("otImp") val otherImport: Double,
    @SerializedName("otImpPorc") val otherImportPercentage: Double,
    @SerializedName("emb") val packaging: Double,
    @SerializedName("idDto") val discountId: Double,
    @SerializedName("prcs") val process: String,
    @SerializedName("img") val img: String? ="",
    @SerializedName("ean") val ean: String? ="",
)

data class Advisor(
    @SerializedName("idAssr") val id: Int,
    @SerializedName("assr") val name: String,
    @SerializedName("tlAssr") val phone: String
)