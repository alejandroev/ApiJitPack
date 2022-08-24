package co.dito.abako.apijitpack.data.model.response.report

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

data class CreditNoteResponse(
    @JsonProperty("IdDevolucionVenta") val idDevolution: Int,
    @JsonProperty("NotaCredito") val creditNote: Int,
    @JsonProperty("Motivo") val reasonReturn: String,
    @JsonProperty("Fecha") val creationDate: Date,
    @JsonProperty("Total") val total: Double,
) {
    @JsonIgnore var details: List<CreditNoteDetailResponse2> = emptyList()
}

data class CreditNoteDetailResponse(
    @JsonProperty("DetalleFactura") val details: ArrayList<CreditNoteDetailResponse2>
)

class CreditNoteDetailResponse2() {

    @JsonProperty("IdDevolucionVenta") var idDevolution: String = ""
    @JsonProperty("Codigo") var articleCode: String = ""
    @JsonProperty("Descripcion") val articleName: String = ""
    @JsonProperty("Cantidad") val quantity: Double = 0.0
    @JsonProperty("UM") val metricUnit: String = ""
    @JsonProperty("Precio") val price: Double = 0.0
    @JsonProperty("SubTotal") val subTotal: Double = 0.0
}