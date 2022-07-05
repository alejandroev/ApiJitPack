package co.dito.abako.apijitpack.data.model.request.general

import co.dito.abako.apijitpack.data.common.converters.DateJsonSerializeOld
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.*

data class GpsTourDetailRequestOld(
    @SerializedName("IdEmp") val idCompany: Double,
    @SerializedName("Lon") val longitude: Double,
    @SerializedName("Lat") val latitude: Double,
    @JsonAdapter(DateJsonSerializeOld::class) @SerializedName("Fc") val creationDate: Date,
    @SerializedName("Tp") val Tp: String
)
