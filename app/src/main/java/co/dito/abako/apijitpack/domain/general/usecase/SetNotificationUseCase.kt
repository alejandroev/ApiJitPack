package co.dito.abako.apijitpack.domain.general.usecase

import co.dito.abako.apijitpack.domain.general.GeneralRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SetNotificationUseCase @Inject constructor(
    private val generalRepository: GeneralRepository
) {

    suspend operator fun invoke(notificationId: Int) : Flow<Boolean> =
        generalRepository.setNotificationRead(notificationId = notificationId)
}