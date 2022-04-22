package co.dito.abako.testsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.general.usecase.PingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val pingUseCase: PingUseCase
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
            pingUseCase("http://abako.ditosas.com/ServicioMovilDITO/ServicioMovilDITO.svc/ping")
                .onStart {
                    setLoading()
                }.catch { exception ->
                    hideLoading()
                    showToast(exception.message.toString())
                }
                .collect { baseResult ->
                    hideLoading()
                    when (baseResult) {
                        is BaseResult.Error -> state.value =
                            MainActivityState.ErrorMain(baseResult.rawResponse)
                        is BaseResult.Success -> state.value =
                            MainActivityState.SuccessMain(baseResult.data)
                    }
                }
        }
    }
}

sealed class MainActivityState {
    object Init : MainActivityState()
    data class IsLoading(val isLoading: Boolean) : MainActivityState()
    data class ShowToast(val message: String) : MainActivityState()
    data class SuccessMain(val response: String) : MainActivityState()
    data class ErrorMain(val rawResponse: WrappedResponse<String>) : MainActivityState()
}
