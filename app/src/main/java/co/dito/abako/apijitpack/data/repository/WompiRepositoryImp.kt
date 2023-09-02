package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.utils.BackEndException
import co.dito.abako.apijitpack.data.common.utils.REQUEST_DATE_FORMAT
import co.dito.abako.apijitpack.data.common.utils.dateFormat
import co.dito.abako.apijitpack.data.model.request.wompi.WompiRequest
import co.dito.abako.apijitpack.data.model.response.inventory.APIInventoryResponse
import co.dito.abako.apijitpack.data.model.response.wompi.TransactionValidationResponse
import co.dito.abako.apijitpack.data.network.WompiAPIService
import co.dito.abako.apijitpack.domain.wompi.WompiRepository
import co.dito.abako.apijitpack.utils.extractArray
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.awaitResponse
import java.util.Date

class WompiRepositoryImp(
    private val wompiAPIService: WompiAPIService
) : WompiRepository {

    override suspend fun fetchConfigurationWompi(
        wompiRequest: WompiRequest,
        redirectUrl: String
    ): Flow<String> = flow {
        val response = wompiAPIService.getWompi(wompiRequest)

        if (response.publicKey.isEmpty() || response.publicKey == "0" || response.signatureIntegrity.isEmpty()) {
            throw BackEndException("Wompi configuration not found")
        }

        val data = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                " \n" +
                "<meta charset=utf-8 />\n" +
                "  \n" +
                "<script type=\"text/javascript\" src=\"https://checkout.wompi.co/widget.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<script>\n" +
                "    wompi ()\n" +
                "    function wompi () {\n" +
                "        var checkout = new WidgetCheckout({\n" +
                "            currency: '${wompiRequest.moneyType}',\n" +
                "            amountInCents:${wompiRequest.amount},\n" +
                "            reference: \"${wompiRequest.validationReference}\",\n" +
                "            publicKey: \"${response.publicKey}\",\n" +
                "            redirectUrl: \"$redirectUrl\"\n" +
                "            })\n" +
                "          \n" +
                "            checkout.open(function ( result ) {\n" +
                "             var transaction = result.transaction\n" +
                "             console.log('TransactionID', transaction.id)\n" +
                "             })\n" +
                "            }\n" +
                "        </script>\n" +
                "</body>\n" +
                "</html>"
        emit(data)
    }

    override suspend fun transactionValidation(
        validationReference: String,
        creationDate: Date
    ): Flow<TransactionValidationResponse?> = flow {
        val response = wompiAPIService.transactionValidation(
            validationReference = validationReference,
            date = creationDate.dateFormat(REQUEST_DATE_FORMAT)
        ).awaitResponse()

        val stringBody = response.body()?.string()
        if (stringBody.isNullOrEmpty() || stringBody == "{}" || stringBody == "{\"data\":[]}") {
            emit(null)
            return@flow
        }

        emit(
            response.extractArray(
                Array<TransactionValidationResponse>::class.java,
                "data",
                stringBody
            )?.firstOrNull() ?: throw Exception("Transaction Validation not found")
        )
    }

    override suspend fun transactionValidation(id: String): Flow<TransactionValidationResponse> =
        flow {
            val response = wompiAPIService.transactionValidationById(
                id = id
            ).awaitResponse().extractArray(
                TransactionValidationResponse::class.java,
                "data"
            ) ?: throw Exception("Transaction Validation not found")

            emit(response)
        }
}