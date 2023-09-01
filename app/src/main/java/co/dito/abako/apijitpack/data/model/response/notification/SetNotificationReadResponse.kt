package co.dito.abako.apijitpack.data.model.response.notification

import com.google.gson.annotations.SerializedName

data class SetNotificationReadResponse(
    @SerializedName("estado") val state: String,
    @SerializedName("mensaje") val message: String,
)
