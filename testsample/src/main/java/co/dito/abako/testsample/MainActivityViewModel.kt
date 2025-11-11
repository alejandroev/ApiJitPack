package co.dito.abako.testsample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.client.APIClientRequest
import co.dito.abako.apijitpack.data.model.request.client.APICreateClientRequest
import co.dito.abako.apijitpack.data.model.request.delivery.ApproveOrderF000Request
import co.dito.abako.apijitpack.data.model.request.firebase.LoginBusinessRequest
import co.dito.abako.apijitpack.data.model.response.article.PlatformType
import co.dito.abako.apijitpack.data.network.ClientAdministrationAPIService
import co.dito.abako.apijitpack.data.network.GeneralMobileApiService
import co.dito.abako.apijitpack.data.network.HostChangeInterceptor
import co.dito.abako.apijitpack.domain.article.usecase.FetchLineArticlesUseCase
import co.dito.abako.apijitpack.domain.client.usecase.CreateClientV1UseCase
import co.dito.abako.apijitpack.domain.client.usecase.GetClientByIdentificationUseCase
import co.dito.abako.apijitpack.domain.firebase.usecase.LoginBusinessUseCase
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
    private val loginBusinessUseCase: LoginBusinessUseCase,
    private val transactionValidationWompiUseCase: TransactionValidationWompiUseCase,
    private val generalMobileApiService: GeneralMobileApiService,
    private val clientAdministrationAPIService: ClientAdministrationAPIService,
    private val editOrderUseCase: co.dito.abako.apijitpack.domain.delivery.usecase.EditOrderUseCase
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
            kotlin.runCatching {
                loginBusinessUseCase(
                    LoginBusinessRequest(
                        business = "elite",
                        password = "123456"
                    )
                ).catch { exception ->
                    print(exception)
                }.collect {
                    print(it)
                }
            }.onFailure {
                it.message
            }

            hostChangeInterceptor.setHost("https://clouderp.abakoerp.com:9480/")

            apiSharedPreference.putURLAdministration(
                "https://clouderp.abakoerp.com:9480/ApiAdministracion/api/"
            )

            apiSharedPreference.putURLMobile(
                "https://clouderp.abakoerp.com:9480/ApiMovil/api/"
            )

            val current = Calendar.getInstance()
            current.set(Calendar.DAY_OF_MONTH, 1)
            current.set(Calendar.HOUR, 0)
            current.set(Calendar.MINUTE, 0)
            current.set(Calendar.SECOND, 0)
            current.set(Calendar.MILLISECOND, 0)

            transactionValidationWompiUseCase(
                validationReference = "6dab3f6d-b582-4094-9c6d-ab3ca26cb770",
                date = current.time
            ).catch { exception ->
                print(exception)
            }.collect {
                print(it)
            }
        }
    }


    fun fetchPendingOrders(idEntrega: Int, idPersona: Int) {
        viewModelScope.launch {
            setLoading()
            try {
                val response = generalMobileApiService.getPendingOrdersDetail(idEntrega, idPersona)
                state.value = MainActivityState.SuccessMain(response)
            } catch (e: Exception) {
                // usar tu ErrorMain genérico
                state.value = MainActivityState.ShowToast("Error: ${e.message}")
            } finally {
                hideLoading()
            }
        }
    }

    fun approveOrder(idPedido: Int, idUsuario: Int) {
        viewModelScope.launch {
            setLoading()
            try {
                val request = ApproveOrderF000Request(idPedido, idUsuario)
                val response = clientAdministrationAPIService.approveOrderF000(request)

                println("✅ Facturación exitosa: $response")
                state.value = MainActivityState.SuccessMain(response)
            } catch (e: Exception) {
                println("❌ Error facturando pedido: ${e.message}")
                state.value = MainActivityState.ShowToast("Error: ${e.message}")
            } finally {
                hideLoading()
            }
        }
    }

    /*fun editOrder() {
        viewModelScope.launch {
            setLoading()
            try {
                // 🟢 1. Armamos el request
                val request = co.dito.abako.apijitpack.data.model.request.delivery.EditPedidoRequest(
                    idPed = 180809,  // 👉 Id del pedido que quieres editar
                    idEmp = 27457,     // 👉 Id empresa o sucursal (ajústalo)
                    obs = "Actualización de cantidad desde prueba",
                    agn = "1",
                    usr = 37501,    // 👉 Id del usuario
                    fnt = 19,        // 👉 Fuente (1 = móvil)
                    dll = listOf(
                        co.dito.abako.apijitpack.data.model.request.delivery.DetallePedido(
                            idArt = 5818,
                            cant = 6.3,
                            um = "UN",
                            desc = 0.05,
                            dct = 0.05,
                            vr = 38235.0
                        )
                    ),
                    dllCmb = emptyList()
                )

                editOrderUseCase(request).collect { response ->
                    val mensaje = response.estado.firstOrNull()?.msgStr ?: "Sin mensaje"
                    Log.d("API_TEST", "✅ Pedido editado: $mensaje")
                    state.value = MainActivityState.SuccessMain(response)
                }

            } catch (e: Exception) {
                Log.e("API_TEST", "❌ Error al editar pedido: ${e.message}")
                state.value = MainActivityState.ShowToast("Error: ${e.message}")
            } finally {
                hideLoading()
            }
        }
    }*/






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
