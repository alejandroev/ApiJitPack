package co.dito.abako.apijitpack.data.model.response.report

data class BodyReportResponse(
    val informSync: InformSync
)
data class InformSync(
    val resultado: Resultado
)
data class Resultado(
    val formaPago: String,
    val pendiente: String,
    val cupo: String
)
