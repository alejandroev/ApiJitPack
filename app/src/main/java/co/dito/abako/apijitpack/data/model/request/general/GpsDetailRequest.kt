package co.dito.abako.apijitpack.data.model.request.general

import co.dito.abako.apijitpack.data.common.converters.DateTimeJsonSerialize
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

data class GpsDetailRequest(
    @SerializedName("idEmp") val idBusiness: Int = 0,
    @SerializedName("lon") val longitude: Double,
    @SerializedName("lat") val latitude: Double,
    @JsonAdapter(DateTimeJsonSerialize::class) @SerializedName("fc") val creationDate: Date,
    @SerializedName("tp") val type: String
)

enum class GPSType(val value: String) {
    DELIVERED("EN"),
    ROUTE("RE"),
    CHECK_IN("IN"),
    CHECK_OUT("OUT"),
}