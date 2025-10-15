package co.dito.abako.apijitpack.data.model.response.delivery

import com.google.gson.annotations.SerializedName

data class OrderPendingItem(
    @SerializedName("idPed") val orderId: Int,
    @SerializedName("idVnt") val saleId: Int,
    @SerializedName("fctr") val factor: Int,
    @SerializedName("fc") val date: String,
    @SerializedName("idEmp") val employeeId: Int,
    @SerializedName("idAssr") val assessorId: Int,
    @SerializedName("fp") val paymentMethod: Int,
    @SerializedName("obs") val observation: String?,
    @SerializedName("otrosValores") val otherValues: Double,
    @SerializedName("idArt") val articleId: Int,
    @SerializedName("cant") val quantity: Double,
    @SerializedName("precio") val price: Double,
    @SerializedName("subtotal") val subtotal: Double,
    @SerializedName("orden") val order: Double
)