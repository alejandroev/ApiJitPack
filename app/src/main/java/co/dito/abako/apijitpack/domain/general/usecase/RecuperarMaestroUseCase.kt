package co.dito.abako.apijitpack.domain.general.usecase

import co.dito.abako.apijitpack.data.model.request.general.MaestroRecuperarRequest
import co.dito.abako.apijitpack.data.model.response.general.MaestroRecuperarItem
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import javax.inject.Inject

class RecuperarMaestroUseCase @Inject constructor(
    private val generalRepository: GeneralRepository,
) {
    suspend operator fun invoke(request: MaestroRecuperarRequest): List<MaestroRecuperarItem> =
        generalRepository.recuperarMaestros(request)
}
