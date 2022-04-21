package co.dito.abako.apijitpack.data.model.request.person

import com.google.gson.annotations.SerializedName

data class CreateCustomer(
    @SerializedName("proceso") val process:Int,
    @SerializedName("cliente") val customer: Customer,
    @SerializedName("mensaje") val message: Message
)
