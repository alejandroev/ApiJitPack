package co.dito.abako.apijitpack.data.model.response.wompi

import com.google.gson.annotations.SerializedName

data class TransactionValidationResponse(
    @SerializedName("id") val id: String,
    @SerializedName("created_at") val created_at: String,
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
