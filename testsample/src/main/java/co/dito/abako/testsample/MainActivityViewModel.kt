package co.dito.abako.testsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.common.utils.ApiAbakoException
import co.dito.abako.apijitpack.data.common.utils.BackEndException
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.repository.utils.ErrorProcessor
import co.dito.abako.apijitpack.domain.ERROR_PROCESSOR_API
import co.dito.abako.apijitpack.domain.delivery.usecase.GetDeliveryResponseUseCase
import co.dito.abako.apijitpack.domain.general.usecase.ExchangeRateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getDeliveryResponseUseCase: GetDeliveryResponseUseCase,
    @Named(ERROR_PROCESSOR_API) private val errorProcessor: ErrorProcessor,
    private val exchangeRateUseCase: ExchangeRateUseCase,
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
            val deliveryRequest = DeliveryRequest(Date(1000, 1, 1), 34)

            getDeliveryResponseUseCase(deliveryRequest)
                .flowOn(Dispatchers.IO)
                .onStart {
                    setLoading()
                }.catch { exception ->
                    if (exception is ApiAbakoException || exception is BackEndException) {
                        val handler = errorProcessor.handlerError(exception)
                        print(handler)
                    }
                    hideLoading()
                }.collect { baseResult ->
                    hideLoading()
                    MainActivityState.SuccessMain(baseResult)
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
