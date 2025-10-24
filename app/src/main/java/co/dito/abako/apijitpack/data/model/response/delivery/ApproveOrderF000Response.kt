package co.dito.abako.apijitpack.data.model.response.delivery

data class ApproveOrderF000Response(
    val id: Int? = null,
    val factura: Int? = null,
    val total: Double? = null,
    val mensaje: Mensaje? = null
) {
    data class Mensaje(
        val msgId: Int? = null,
        val msgStr: String? = null
    )
}