package co.dito.abako.apijitpack.data.model.response.wompi

import co.dito.abako.apijitpack.data.common.converters.DateTimeJsonDeserializeWompi
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

data class TransactionValidationResponse(
    @SerializedName("id") val id: String,
    @JsonAdapter(DateTimeJsonDeserializeWompi::class) @SerializedName("created_at") val createdAt: Date,
    @SerializedName("amount_in_cents") val amountInCents: Int,
    @SerializedName("status") val status: StatusType,
    @SerializedName("reference") val reference: String,
    @SerializedName("currency") val currency: String,
    @SerializedName("payment_method_type") val paymentMethodType: String,
) {

    enum class StatusType {
        APPROVED,
        DECLINED,
        VOIDED,
        ERROR,
        PENDING
    }
}
