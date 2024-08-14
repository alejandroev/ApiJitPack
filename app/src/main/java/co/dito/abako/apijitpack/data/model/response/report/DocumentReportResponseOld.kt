package co.dito.abako.apijitpack.data.model.response.report

import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

data class DocumentReportResponseOld(
    @SerializedName("Encabezado") val header: String,
    @SerializedName("Detalle") val detail: String
) : MessageResponseOld()
