package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

data class GpsTourResponseOld(
    @SerializedName("Estado") val state: MessageResponseOld
) : MessageResponseOld()
