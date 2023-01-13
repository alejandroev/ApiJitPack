package co.dito.abako.apijitpack.domain.notification

import co.dito.abako.apijitpack.data.model.request.notification.NotificationFCMRequest
import co.dito.abako.apijitpack.data.model.response.notification.NotificationFCMResponse

interface NotificationFCMRepository {

   suspend fun sendNotification(notificationFCMRequest: NotificationFCMRequest) : NotificationFCMResponse
}