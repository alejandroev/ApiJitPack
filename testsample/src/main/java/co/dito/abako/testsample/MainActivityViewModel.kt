package co.dito.abako.testsample

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.common.utils.ApiAbakoException
import co.dito.abako.apijitpack.data.common.utils.BackEndException
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsDetailRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.repository.utils.ErrorProcessor
import co.dito.abako.apijitpack.domain.ERROR_PROCESSOR_API
import co.dito.abako.apijitpack.domain.delivery.usecase.GetDeliveryResponseUseCase
import co.dito.abako.apijitpack.domain.delivery.usecase.GetReportDocumentResponseUseCase
import co.dito.abako.apijitpack.domain.general.usecase.ExchangeRateUseCase
import co.dito.abako.apijitpack.domain.general.usecase.InsertGpsTourUseCase
import co.dito.abako.apijitpack.utils.getBatteryLevel
import co.dito.abako.apijitpack.utils.sendEmail.EmailSender
import co.dito.abako.apijitpack.utils.sendEmail.data.EmailBody
import co.dito.abako.apijitpack.utils.sendEmail.data.EmailBodyError
import co.dito.abako.apijitpack.utils.sendEmail.data.EmailData
import co.dito.abako.apijitpack.utils.sendEmail.data.EmailType
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Date
import javax.inject.Inject
import javax.inject.Named
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val getDeliveryResponseUseCase: GetDeliveryResponseUseCase,
    private val emailSender: EmailSender,
    @Named(ERROR_PROCESSOR_API) private val errorProcessor: ErrorProcessor,
    private val getReportDocumentResponseUseCase: GetReportDocumentResponseUseCase,
    private val exchangeRateUseCase: ExchangeRateUseCase,
    private val insertGpsTourUseCase: InsertGpsTourUseCase,
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
        viewModelScope.launch {
            getReportDocumentResponseUseCase(DocumentReportRequest(1, "123", 12))
                .catch { exception ->
                    exception.printStackTrace()
                }
                .collect {
                    print(it.toString())
                }

            /*val data = EmailData(
                title = "TEST SERVER",
                bodyError = EmailBodyError(
                    url = "test.com",
                    request = "hola",
                    response = "response",
                    resultCode = 500,
                    timeResponse = 1
                ),
                type = EmailType.AUTOMATIC
            )

            try {
                emailSender.sendEmail(data)
            }catch (ex: Exception) {
                ex.printStackTrace()
            }*/
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
