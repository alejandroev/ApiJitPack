package co.dito.abako.apijitpack.data.model.request.order

import co.dito.abako.apijitpack.data.common.converters.DateJsonSerialize
import co.dito.abako.apijitpack.data.common.converters.DateTimeJsonSerialize
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

data class APIOrderRequest(
    @SerializedName("idEmp") val idEmployee: Int,
    @SerializedName("tp") val type: String,
    @SerializedName("otDcto") val otherDiscount: Double,
    @SerializedName("obs") val obs: String,
    @SerializedName("cnt") val contactId: Int,
    @SerializedName("usr") val userId: Int,
    @SerializedName("fnt") val font: Int,
    @SerializedName("dir") val addressId: Int,
    @JsonAdapter(DateJsonSerialize::class) @SerializedName("fcent") val deliveryDate: Date,
    @JsonAdapter(DateTimeJsonSerialize::class) @SerializedName("fc") val creationDate: Date,
    @SerializedName("agn") val agency: String,
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double,
    @SerializedName("rfv") val validationReference: String,
    @SerializedName("dll") val detailOrder: List<APIOrderDetailRequest>,
    @SerializedName("dllCmb") val changeOrder: List<APIOrderChangeRequest> = emptyList()
)

data class APIOrderDetailRequest(
    @SerializedName("idArt") val articleId: Int,
    @SerializedName("cant") val quantity: Double,
    @SerializedName("um") val metricUnit: String,
    @SerializedName("desc") val discount: Double,
    @SerializedName("dct") val dct: Int,
    @SerializedName("vr") val unitPrice: Double
)

data class APIOrderChangeRequest(
    @SerializedName("idArt") val articleId: Int,
    @SerializedName("cant") val quantity: Double,
    @SerializedName("um") val metricUnit: String
)
