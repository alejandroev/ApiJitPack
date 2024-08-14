package co.dito.abako.apijitpack.domain.wompi.usecase

import co.dito.abako.apijitpack.data.model.response.wompi.TransactionValidationResponse
import co.dito.abako.apijitpack.domain.wompi.WompiRepository
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject

class TransactionValidationWompiUseCase @Inject constructor(
    private val wompiRepository: WompiRepository
) {

    suspend operator fun invoke(validationReference: String, date: Date): Flow<TransactionValidationResponse?> =
        wompiRepository.transactionValidation(validationReference, date)
}