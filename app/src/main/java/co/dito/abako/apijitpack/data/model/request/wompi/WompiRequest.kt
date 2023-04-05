package co.dito.abako.apijitpack.data.model.request.wompi

import com.google.gson.annotations.SerializedName

data class WompiRequest(
    @SerializedName("referencia") val validationReference: String,
    @SerializedName("monto") val amount: String,
    @SerializedName("moneda") val moneyType: MoneyType = MoneyType.COP,
)

enum class MoneyType {
    COP,
    US
}