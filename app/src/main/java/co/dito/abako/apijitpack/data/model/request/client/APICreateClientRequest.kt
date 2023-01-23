package co.dito.abako.apijitpack.data.model.request.client

import co.dito.abako.apijitpack.data.common.converters.DateTimeJsonSerialize
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

data class APICreateClientRequest(
    @SerializedName("proceso") val process: Int,
    @SerializedName("cliente") val apiClientRequest: APIClientRequest
)

data class APIClientRequest(
    @SerializedName("idEmp") val companyId: Int,
    @SerializedName("idUsr") val userId: Int,
    @SerializedName("idZn") val zoneId: Int,
    @SerializedName("idCnl") val channelId: Int,
    @SerializedName("idSgt") val segmentId: Int,
    @SerializedName("idnt") val identification: String,
    @SerializedName("idTpdoc") val typeDocumentId: Int,
    @SerializedName("rzScl") val businessName: String,
    @SerializedName("nmbCmn") val commonName: String,
    @SerializedName("nmbCtt") val contactFirstNames: String,
    @SerializedName("aplCtt") val contactLastNames: String,
    @SerializedName("mail") val email: String,
    @SerializedName("tel") val phone: String,
    @SerializedName("idPref") val prefixId: Int,
    @SerializedName("dirNum") val addressNumber: String,
    @SerializedName("dirInter") val addressInterception: String,
    @SerializedName("dirDet") val addressDetail: String,
    @SerializedName("dirIdBarr") val neighborhoodId: Int,
    @JsonAdapter(DateTimeJsonSerialize::class) @SerializedName("fc") val creationDate: Date,
    @SerializedName("lon") val longitude: Double,
    @SerializedName("lat") val latitude: Double,
    @SerializedName("rfv") val validationReference: String,
    @SerializedName("rut") val routes: List<APIRouteClientRequest> = emptyList(),
)

data class APIRouteClientRequest(
    @SerializedName("dia") val day: Int,
    @SerializedName("orden") val order: Int,
)
