package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.utils.BackEndException
import co.dito.abako.apijitpack.data.model.request.wompi.WompiRequest
import co.dito.abako.apijitpack.data.network.WompiAPIService
import co.dito.abako.apijitpack.domain.wompi.WompiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WompiRepositoryImp(
    private val wompiAPIService: WompiAPIService
) : WompiRepository {

    override suspend fun fetchConfigurationWompi(wompiRequest: WompiRequest, redirectUrl: String): Flow<String> = flow {
        val response = wompiAPIService.getWompi(wompiRequest)
        // response.publicKey == "0" ||
        if (response.publicKey.isEmpty() || response.signatureIntegrity.isEmpty()) {
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
                "            redirectUrl: '$redirectUrl'\n" +
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
}