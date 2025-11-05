package co.dito.abako.apijitpack.data.model.response.delivery

data class EditPedidoResponse(
    val estado: List<EstadoResponse>,
    val inventario: List<InventarioResponse>,
    val idPed: Int,
    val ped: Int,
    val correo: String
)

data class EstadoResponse(
    val msgId: Int,
    val msgStr: String
)

data class InventarioResponse(
    val idArt: Int,
    val stk: Double,
    val tst: Double,
    val pd: Double,
    val agc: String
)