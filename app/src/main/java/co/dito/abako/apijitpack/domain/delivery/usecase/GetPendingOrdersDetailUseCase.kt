package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponseApi
import co.dito.abako.apijitpack.data.network.GeneralMobileApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Caso de uso encargado de obtener los pedidos pendientes
 * asociados a una planilla (entrega).
 *
 * Endpoint: Entregas/GetEntregaDetallePedidosPendientes/{IdEntrega}/{IdPersona}
 */
class GetPendingOrdersDetailUseCase @Inject constructor(
    private val api: GeneralMobileApiService
) {
    suspend operator fun invoke(
        idDelivery: Int,
        idPersona: Int
    ) = flow<DeliveryDetailResponseApi> {
        emit(api.getPendingOrdersDetail(idDelivery, idPersona))
    }
}