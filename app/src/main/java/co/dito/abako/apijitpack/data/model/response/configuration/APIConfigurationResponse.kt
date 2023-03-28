package co.dito.abako.apijitpack.data.model.response.configuration

import com.google.gson.annotations.SerializedName

data class APIConfigurationResponse(
    @SerializedName("vrbl") val configurationId: Int,
    @SerializedName("dscp") val description: String,
    @SerializedName("act") val active: String,
    @SerializedName("vlr") val value: String,
    @SerializedName("edi") val editable: String,
    @SerializedName("vis") val visible: String,
    @SerializedName("mtdt") val metadata: String,
    @SerializedName("fnt") val font: String
)