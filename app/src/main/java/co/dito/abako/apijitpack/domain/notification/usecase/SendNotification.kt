package co.dito.abako.apijitpack.domain.notification.usecase

import co.dito.abako.apijitpack.data.model.request.notification.NotificationFCMRequest
import co.dito.abako.apijitpack.domain.notification.NotificationFCMRepository
import javax.inject.Inject

class SendNotification @Inject constructor(
    private val repository: NotificationFCMRepository
) {

    suspend operator fun invoke(notificationFCMRequest: NotificationFCMRequest) = repository.sendNotification(notificationFCMRequest)
}