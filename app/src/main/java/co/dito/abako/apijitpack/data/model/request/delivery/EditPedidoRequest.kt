package co.dito.abako.apijitpack.data.model.request.delivery

data class EditPedidoRequest(
    val idPed: Int,
    val idEmp: Int,
    val obs: String,
    val agn: String,
    val usr: Int,
    val fnt: Int,
    val dll: List<DetallePedido>,
    val dllCmb: List<DetalleCambio> = emptyList(),
    val id: Int,          // 👈 igual que en el JSON de pedidos
    val tipoDoc: Int,     // 👈 igual que en el JSON de pedidos
    val vrTotal: Double   // 👈 total del pedido después de editar
)

data class DetallePedido(
    val idArt: Int,
    val cant: Double,
    val um: String,
    val desc: Double,
    val dct: Double,
    val vr: Double,
    val idMotivo: Int,    // 👈 lo vimos en el JSON de pedidos (idMotivo)
    val lp: Int           // 👈 lista de precios usada para validar la UM
)

data class DetalleCambio(
    val idArt: Int,
    val idMtv: Int,
    val cant: Double,
    val um: String,
    val obs: String
)