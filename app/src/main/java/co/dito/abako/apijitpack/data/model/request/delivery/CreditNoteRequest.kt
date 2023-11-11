package co.dito.abako.abako.abako.data.model

import co.dito.abako.apijitpack.data.common.converters.DateTimeJsonSerialize
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

data class CreditNoteRequest (
        @SerializedName("key") val key: String = "",
        @SerializedName("idVnt") val idVnt: Int = 0,
        @SerializedName("idPed") val idPed: Int = 0,
        @SerializedName("idMot") val idMot: Int = 0,
        @SerializedName("obs") val obs: String = "",
        @JsonAdapter(DateTimeJsonSerialize::class) @SerializedName("fc") val fc: Date,
        @SerializedName("usr") val usr: Int = 0,
        @SerializedName("lon") val lon: Double = 0.0,
        @SerializedName("lat") val lat: Double = 0.0,
        @SerializedName("rfv") val rfv: String = "",
        @SerializedName("dll") val dll: List<DllItemCredit> = emptyList()
    )
