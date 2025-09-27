package co.dito.abako.apijitpack.data.model.response.report


import com.google.gson.annotations.SerializedName

// ===== Response =====
data class APIReportAtributeResponse(
    @SerializedName("resultado")
    val resultado: List<ResultadoAtribute>,
    @SerializedName("registros")
    val registros: Int
)
data class ResultadoAtribute(
    @SerializedName("Id") val id: String,
    @SerializedName("Planilla") val planilla: String,
    @SerializedName("Facturas") val facturas: String,
    @SerializedName("FacturasContado") val facturasContado: String,
    @SerializedName("FacturaCredito") val facturaCredito: String,
    @SerializedName("TotalCargue") val totalCargue: String,
    @SerializedName("NotasContado") val notasContado: String,
    @SerializedName("notasCredito") val notasCredito: String,
    @SerializedName("OtrosCobro") val otrosCobro: String,
    @SerializedName("CambiosContado") val cambiosContado: String,
    @SerializedName("CambiosCredito") val cambiosCredito: String,
    @SerializedName("Liquidar") val liquidar: String,
    @SerializedName("Liquidacion") val liquidacion: String,
    @SerializedName("Descuadre") val descuadre: String,
    @SerializedName("Entrega") val entrega: String,      // "YYYY-MM-DD HH:mm"
    @SerializedName("Creacion") val creacion: String,    // "YYYY-MM-DD HH:mm"
    @SerializedName("Estado") val estado: String,
    @SerializedName("FacturacionAntesImpuestos") val facturacionAntesImpuestos: String,
    @SerializedName("NotasCreditoAntesImpuestos") val notasCreditoAntesImpuestos: String,
    @SerializedName("Observacion") val observacion: String? = null // opcional
)

