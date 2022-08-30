package co.dito.abako.apijitpack.data.model.response.support

import com.google.gson.annotations.SerializedName

data class SupportResponse(
    @SerializedName("message") val message: String
)
