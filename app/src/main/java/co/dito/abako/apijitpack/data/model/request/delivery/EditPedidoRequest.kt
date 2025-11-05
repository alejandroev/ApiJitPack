package co.dito.abako.apijitpack.data.model.request.delivery

data class EditPedidoRequest(
    val idPed: Int,
    val idEmp: Int,
    val obs: String,
    val agn: String,
    val usr: Int,
    val fnt: Int,
    val dll: List<DetallePedido>,
    val dllCmb: List<DetalleCambio>
)

data class DetallePedido(
    val idArt: Int,
    val cant: Double,
    val um: String,
    val desc: Double,
    val dct: Double,
    val vr: Double
)

data class DetalleCambio(
    val idArt: Int,
    val idMtv: Int,
    val cant: Double,
    val um: String,
    val obs: String
)