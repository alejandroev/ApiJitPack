package co.dito.abako.apijitpack.data.model.response.wompi

import com.google.gson.annotations.SerializedName

data class WompiResponse(
    @SerializedName("publickey") val publicKey: String,
    @SerializedName("signatureintegrity") val signatureIntegrity: String
)