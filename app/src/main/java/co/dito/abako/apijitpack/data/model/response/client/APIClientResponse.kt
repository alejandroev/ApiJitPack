package co.dito.abako.apijitpack.data.model.response.client

import co.dito.abako.apijitpack.data.common.converters.DateTimeJsonDeserialize
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

data class APIAbakoClientResponse(
    @SerializedName("usuario") val userResponse: List<APIAbakoUserResponse>,
    @SerializedName("comercial") val commercialResponse: List<APIAbakoCommercialResponse>,
    @SerializedName("estado") val state: List<MessageResponse>,
    @SerializedName("notificaciones") val notifications: List<NotificationResponse>
)

data class APIAbakoUserResponse(
    @SerializedName("idEmp") var companyId: Int,
    @SerializedName("idnt") var identification: String,
    @SerializedName("cod") var code: String,
    @SerializedName("rzScl") var businessName: String,
    @SerializedName("nmbCmn") var commonName: String,
    @SerializedName("idPersona") var personId: Int,
    @SerializedName("nmbr") var fullName: String,
    @SerializedName("idDir") var addressId: Int,
    @SerializedName("tel") var phone: String,
    @SerializedName("mail") var email: String,
    @SerializedName("idAgc") var agencyId: String?,
    @SerializedName("agc") var agencyName: String?,
    @SerializedName("nmb") var firstNames: String,
    @SerializedName("apll") var lastNames: String,
    @SerializedName("idAsr") var idAsr: String,
    @SerializedName("assr") var assr: String,
)

data class APIAbakoCommercialResponse(
    @SerializedName("idEmp") val companyId: Int,
    @SerializedName("cnl") val channelName: String,
    @SerializedName("zn") val zoneName: String,
    @SerializedName("idLP") val priceListId: Int,
    @SerializedName("lp") val priceListName: String,
    @SerializedName("lon") val longitude: Double,
    @SerializedName("lat") val latitude: Double,
    @SerializedName("fp") val wayToPay: String,
    @SerializedName("cp") val quota: Double,
    @SerializedName("vncmnt") val expirationDays: Int,
    @JsonAdapter(DateTimeJsonDeserialize::class) @SerializedName("ultVt") val lastSale: Date?,
    @JsonAdapter(DateTimeJsonDeserialize::class) @SerializedName("fchltmpg") val dateLastPayment: Date?,
    @SerializedName("ultmpg") val lastPayment: Double

)

data class NotificationResponse(
    @SerializedName("id") val notificationId: Int,
    @JsonAdapter(DateTimeJsonDeserialize::class) @SerializedName("fecha") val creationDate: Date,
    @SerializedName("titulo") val title: String,
    @SerializedName("mensaje") val message: String,
)