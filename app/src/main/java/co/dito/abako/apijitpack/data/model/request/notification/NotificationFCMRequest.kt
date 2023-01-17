package co.dito.abako.apijitpack.data.model.request.notification


data class NotificationFCMRequest(
    val to: String,
    val data: Map<String, String>
)