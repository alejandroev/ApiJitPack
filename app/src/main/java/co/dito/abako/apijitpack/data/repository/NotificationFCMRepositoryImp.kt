package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.model.request.notification.NotificationFCMRequest
import co.dito.abako.apijitpack.data.model.response.notification.NotificationFCMResponse
import co.dito.abako.apijitpack.data.network.NotificationFCMApiService
import co.dito.abako.apijitpack.domain.notification.NotificationFCMRepository
import javax.inject.Inject

class NotificationFCMRepositoryImp @Inject constructor(
    private val service: NotificationFCMApiService
) : NotificationFCMRepository {

    override suspend fun sendNotification(notificationFCMRequest: NotificationFCMRequest): NotificationFCMResponse = service.sentNotificationSingle(notificationFCMRequest)
}