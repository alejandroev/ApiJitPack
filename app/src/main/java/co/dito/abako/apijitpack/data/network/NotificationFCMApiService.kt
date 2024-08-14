package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.notification.NotificationFCMRequest
import co.dito.abako.apijitpack.data.model.response.notification.NotificationFCMResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface NotificationFCMApiService {

    @POST("send")
    suspend fun sentNotificationSingle(@Body notificationFCMRequest: NotificationFCMRequest): NotificationFCMResponse
}