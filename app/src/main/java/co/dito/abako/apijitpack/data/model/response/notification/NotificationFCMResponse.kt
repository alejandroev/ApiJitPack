package co.dito.abako.apijitpack.data.model.response.notification

data class NotificationFCMResponse(
    val multicast_id: String,
    val success: Int,
    val failure: Int
)