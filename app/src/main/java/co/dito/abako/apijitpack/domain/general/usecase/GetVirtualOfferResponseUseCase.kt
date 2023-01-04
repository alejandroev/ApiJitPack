package co.dito.abako.apijitpack.domain.general.usecase

import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVirtualOfferResponseUseCase @Inject constructor(private val generalRepository: GeneralRepository) {

    suspend operator fun invoke(virtualOfferRequest: VirtualOfferRequest) : Flow<VirtualOfferResponse> =
        generalRepository.getVirtualOfferResponse(virtualOfferRequest)
}