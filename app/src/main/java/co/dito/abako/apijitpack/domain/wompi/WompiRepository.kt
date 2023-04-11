package co.dito.abako.apijitpack.domain.wompi

import co.dito.abako.apijitpack.data.model.request.wompi.WompiRequest
import co.dito.abako.apijitpack.data.model.response.wompi.TransactionValidationResponse
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface WompiRepository {

    suspend fun fetchConfigurationWompi(wompiRequest: WompiRequest, redirectUrl: String) : Flow<String>

    suspend fun transactionValidation(validationReference: String, creationDate: Date) : Flow<TransactionValidationResponse>

    suspend fun transactionValidation(id: String) : Flow<TransactionValidationResponse>
}