package co.dito.abako.apijitpack.data.model.request.order

import com.google.gson.annotations.SerializedName

data class OrderTracking(
    @SerializedName("idPedido") val idOrder: Int,
    @SerializedName("pedido") val order: Int,
    @SerializedName("correo") val mail: String
)
