package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.request.delivery.EditPedidoRequest
import co.dito.abako.apijitpack.data.model.response.delivery.EditPedidoResponse
import co.dito.abako.apijitpack.data.network.GeneralMobileApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/**
 * Caso de uso encargado de editar un pedido existente
 * mediante el endpoint: Pedidos/EditarPedidoF000
 */
class EditOrderUseCase @Inject constructor(
    private val api: GeneralMobileApiService
) {
    suspend operator fun invoke(
        request: EditPedidoRequest
    ) = flow<EditPedidoResponse> {
        emit(api.editPedido(request))
    }
}