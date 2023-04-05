package co.dito.abako.apijitpack.domain.wompi

import co.dito.abako.apijitpack.data.model.request.wompi.WompiRequest
import kotlinx.coroutines.flow.Flow

interface WompiRepository {

    suspend fun fetchConfigurationWompi(wompiRequest: WompiRequest, redirectUrl: String) : Flow<String>
}