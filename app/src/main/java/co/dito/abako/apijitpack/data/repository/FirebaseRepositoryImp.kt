package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.model.request.support.SupportRequest
import co.dito.abako.apijitpack.data.model.response.support.SupportResponse
import co.dito.abako.apijitpack.data.network.FirebaseApiService
import co.dito.abako.apijitpack.domain.support.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseRepositoryImp @Inject constructor(
    private val supportApiService: FirebaseApiService
) : FirebaseRepository {

    override suspend fun getSupportResponse(supportRequest: SupportRequest) : Flow<SupportResponse> {
        return flow {
            supportApiService.supportCodi(supportRequest).let {
                val response = SupportResponse(message = it.message)
                emit(response)
            }
        }
    }
}