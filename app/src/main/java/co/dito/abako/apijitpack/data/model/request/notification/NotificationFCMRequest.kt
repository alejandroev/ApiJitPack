package co.dito.abako.apijitpack.data.model.request.notification


data class NotificationFCMRequest(
    val to: String,
    val notification: DetailNotificationFCMRequest
)

data class DetailNotificationFCMRequest(
    val body: String,
    val subtitle: String = "",
    val title: String = ""
)
