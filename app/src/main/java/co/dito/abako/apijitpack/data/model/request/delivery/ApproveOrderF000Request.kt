package co.dito.abako.apijitpack.data.model.request.delivery

data class ApproveOrderF000Request(
    val idPedido: Int,
    val idUsuario: Int,
    val detallePago: List<Any> = emptyList(),
    val detalleOtrosConceptos: List<Any> = emptyList()
)