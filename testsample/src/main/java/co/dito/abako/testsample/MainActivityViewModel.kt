package co.dito.abako.testsample

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.firebase.LoginBusinessRequest
import co.dito.abako.apijitpack.data.model.request.notification.NotificationFCMRequest
import co.dito.abako.apijitpack.data.repository.utils.ErrorProcessor
import co.dito.abako.apijitpack.domain.ERROR_PROCESSOR_API
import co.dito.abako.apijitpack.domain.client.usecase.GetClientByIdentificationUseCase
import co.dito.abako.apijitpack.domain.client.usecase.VerifyClientExistByIdentificationUseCase
import co.dito.abako.apijitpack.domain.delivery.usecase.GetDeliveryResponseUseCase
import co.dito.abako.apijitpack.domain.delivery.usecase.GetReportDocumentResponseUseCase
import co.dito.abako.apijitpack.domain.delivery.usecase.GetReportResponseUseCase
import co.dito.abako.apijitpack.domain.firebase.usecase.LoginBusinessUseCase
import co.dito.abako.apijitpack.domain.general.usecase.ExchangeRateUseCase
import co.dito.abako.apijitpack.domain.general.usecase.InsertGpsTourUseCase
import co.dito.abako.apijitpack.domain.notification.usecase.SendNotificationUseCase
import co.dito.abako.apijitpack.utils.ApiSharedPreference
import co.dito.abako.apijitpack.utils.backupDocument.BackupDocument
import co.dito.abako.apijitpack.utils.backupDocument.BackupRequestData
import co.dito.abako.apijitpack.utils.sendEmail.EmailSender
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Date
import javax.inject.Inject
import javax.inject.Named
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val backupDocument: BackupDocument<BackupOrden>,
    private val getDeliveryResponseUseCase: GetDeliveryResponseUseCase,
    private val emailSender: EmailSender,
    @Named(ERROR_PROCESSOR_API) private val errorProcessor: ErrorProcessor,
    private val getReportDocumentResponseUseCase: GetReportDocumentResponseUseCase,
    private val getReportResponseUseCase: GetReportResponseUseCase,
    private val apiSharedPreference: ApiSharedPreference,
    private val exchangeRateUseCase: ExchangeRateUseCase,
    private val insertGpsTourUseCase: InsertGpsTourUseCase,
    private val sendNotificationUseCase: SendNotificationUseCase,
    private val loginBusinessUseCase: LoginBusinessUseCase,
    private val verifyClientExistByIdentificationUseCase: VerifyClientExistByIdentificationUseCase,
    private val getClientByIdentificationUseCase: GetClientByIdentificationUseCase
) : ViewModel() {

    private val state = MutableStateFlow<MainActivityState>(MainActivityState.Init)
    val mState: StateFlow<MainActivityState> get() = state

    private fun setLoading() {
        state.value = MainActivityState.IsLoading(true)
    }

    private fun hideLoading() {
        state.value = MainActivityState.IsLoading(false)
    }

    private fun showToast(message: String) {
        state.value = MainActivityState.ShowToast(message)
    }

    init {
        ping()
    }

    private fun ping() {
        apiSharedPreference.putCodeCODI("1732")

        viewModelScope.launch {
            getClientByIdentificationUseCase("11105879700000")
                .catch { exception ->
                    print(exception)
                }
                .collect {
                    print(it)
                }
        }
    }
}

sealed class MainActivityState {
    object Init : MainActivityState()
    data class IsLoading(val isLoading: Boolean) : MainActivityState()
    data class ShowToast(val message: String) : MainActivityState()
    data class SuccessMain<T>(val response: T) : MainActivityState()
    data class ErrorMain<T>(val rawResponse: WrappedResponse<T>) : MainActivityState()
}


data class BackupOrden(
    override val creationDateBackup: Date = Date(),
    override val updateDateBackup: Date = Date(),
    val list: List<String> = emptyList()
) : BackupRequestData(creationDateBackup, updateDateBackup)
