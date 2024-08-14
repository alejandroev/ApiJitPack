package co.dito.abako.apijitpack.data.model.request.order

import com.google.gson.annotations.SerializedName

data class FollowUpOrderRequest(
    @SerializedName("idPedido") val orderId: Int,
    @SerializedName("pedido") val orderConsecutive: Int,
    @SerializedName("correo") val email: String
)
