package co.dito.abako.testsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.order.APIOrderDetailRequest
import co.dito.abako.apijitpack.data.model.request.order.APIOrderRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.network.HostChangeInterceptor
import co.dito.abako.apijitpack.domain.delivery.usecase.FetchHistoryClientReportUseCase
import co.dito.abako.apijitpack.domain.favorite.FetchFavoriteArticlesUseCase
import co.dito.abako.apijitpack.domain.favorite.FetchSetFavoriteArticlesUseCase
import co.dito.abako.apijitpack.domain.order.usecase.InsertOrderUseCase
import co.dito.abako.apijitpack.utils.ApiSharedPreference
import co.dito.abako.apijitpack.utils.backupDocument.BackupRequestData
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.util.UUID

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val apiSharedPreference: ApiSharedPreference,
    private val hostChangeInterceptor: HostChangeInterceptor,
    private val fetchHistoryClientReportUseCase: FetchHistoryClientReportUseCase
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
            hostChangeInterceptor.setHost("https://clouderp.abakoerp.com:9480/")

            val request = DocumentReportRequest(
                searchId = "16364",
                personId = 16364
            )

            fetchHistoryClientReportUseCase(request)
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
