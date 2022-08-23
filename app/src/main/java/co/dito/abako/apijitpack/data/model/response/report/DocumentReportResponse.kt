package co.dito.abako.apijitpack.data.model.response.report

import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import com.google.gson.annotations.SerializedName

data class DocumentReportResponse(
    @SerializedName("encabezado") val header: String,
    @SerializedName("detalle") val detail: String
) : MessageResponse()
