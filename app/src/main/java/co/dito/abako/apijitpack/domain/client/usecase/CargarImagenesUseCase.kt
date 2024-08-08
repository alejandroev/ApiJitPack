package co.dito.abako.apijitpack.domain.client.usecase

import co.dito.abako.apijitpack.data.model.response.CargarImagenesModelResponse
import co.dito.abako.apijitpack.data.model.response.ImagenesRequest
import co.dito.abako.apijitpack.domain.client.ClientRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CargarImagenesUseCase @Inject constructor(
    private val clientRepository: ClientRepository
) {

    suspend operator fun invoke(imagenesRequest: ImagenesRequest): Flow<CargarImagenesModelResponse> =
        clientRepository.fetchImagen(imagenesRequest)
}