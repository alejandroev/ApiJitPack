package co.dito.abako.apijitpack.domain.notification.usecase

import co.dito.abako.apijitpack.data.model.request.notification.NotificationFCMRequest
import co.dito.abako.apijitpack.domain.notification.NotificationFCMRepository
import javax.inject.Inject

class SendNotificationUseCase @Inject constructor(
    private val repository: NotificationFCMRepository
) {

    suspend operator fun invoke(
        to: String,
        title: String,
        body: String,
        notificationType: String,
        data: HashMap<String, String> = hashMapOf()
    ) {
        data[TITLE_KEY] = title
        data[BODY_KEY] = body
        data[NOTIFICATION_TYPE_KEY] = notificationType

        repository.sendNotification(NotificationFCMRequest(to = to, data = data))
    }
}

const val TITLE_KEY = "title"
const val BODY_KEY = "body"
const val NOTIFICATION_TYPE_KEY = "notification_type"