package co.dito.abako.apijitpack.data.model.request.general

import co.dito.abako.apijitpack.data.common.converters.DateJsonSerializeOld
import co.dito.abako.apijitpack.data.common.converters.DateTimeJsonSerialize
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.*

data class GpsDetailRequestOld(
    @SerializedName("IdEmp") val idBusiness: Int,
    @SerializedName("Lon") val longitude: Double,
    @SerializedName("Lat") val latitude: Double,
    @JsonAdapter(DateTimeJsonSerialize::class) @SerializedName("Fc") val creationDate: Date,
    @SerializedName("Tp") val type: String
)
