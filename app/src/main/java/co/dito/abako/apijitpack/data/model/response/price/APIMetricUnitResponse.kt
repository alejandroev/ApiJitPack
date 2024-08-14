package co.dito.abako.apijitpack.data.model.response.price

import com.google.gson.annotations.SerializedName

data class APIMetricUnitResponse(
    @SerializedName("um") val metricUnitCode: String,
    @SerializedName("dum") val metricUnitDescription: String
)
