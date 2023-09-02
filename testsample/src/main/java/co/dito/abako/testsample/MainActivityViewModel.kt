package co.dito.abako.testsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.client.APIClientRequest
import co.dito.abako.apijitpack.data.model.request.client.APICreateClientRequest
import co.dito.abako.apijitpack.data.model.response.article.PlatformType
import co.dito.abako.apijitpack.data.network.HostChangeInterceptor
import co.dito.abako.apijitpack.domain.article.usecase.FetchLineArticlesUseCase
import co.dito.abako.apijitpack.domain.client.usecase.CreateClientV1UseCase
import co.dito.abako.apijitpack.domain.client.usecase.GetClientByIdentificationUseCase
import co.dito.abako.apijitpack.domain.general.usecase.SetNotificationUseCase
import co.dito.abako.apijitpack.domain.wompi.usecase.TransactionValidationWompiUseCase
import co.dito.abako.apijitpack.utils.ApiSharedPreference
import co.dito.abako.apijitpack.utils.backupDocument.BackupRequestData
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.UUID

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val apiSharedPreference: ApiSharedPreference,
    private val hostChangeInterceptor: HostChangeInterceptor,
    private val transactionValidationWompiUseCase: TransactionValidationWompiUseCase
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
            hostChangeInterceptor.setHost("https://clouderp.abakoerp.com:9444/")

            val current = Calendar.getInstance()
            current.set(Calendar.DAY_OF_MONTH, 1)
            current.set(Calendar.HOUR, 0)
            current.set(Calendar.MINUTE, 0)
            current.set(Calendar.SECOND, 0)
            current.set(Calendar.MILLISECOND, 0)

            transactionValidationWompiUseCase(
                validationReference = "6dab3f6d-b582-4094-9c6d-ab3ca26cb770",
                date = current.time
            ).catch {exception ->
                print(exception)
            }.collect {
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
