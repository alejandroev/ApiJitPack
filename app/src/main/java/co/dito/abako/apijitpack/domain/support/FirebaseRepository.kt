package co.dito.abako.apijitpack.domain.support

import co.dito.abako.apijitpack.data.model.request.support.SupportRequest
import co.dito.abako.apijitpack.data.model.response.support.SupportResponse
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {

    suspend fun getSupportResponse(supportRequest: SupportRequest) : Flow<SupportResponse>
}