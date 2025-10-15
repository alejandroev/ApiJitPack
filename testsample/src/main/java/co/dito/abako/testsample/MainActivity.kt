package co.dito.abako.testsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()

        observe()
        viewModel.fetchPendingOrders(idEntrega = 10848, idPersona = 16813)
    }

    private fun observe() {
        viewModel.mState
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { state -> handleStateChange(state) }
            .launchIn(lifecycleScope)
    }

    private fun handleStateChange(state: MainActivityState) {
        when (state) {
            is MainActivityState.Init -> Unit
            is MainActivityState.ErrorMain<*> -> {
                Log.e("API_TEST", "❌ Error: ${state.rawResponse.message}")
                Toast.makeText(
                    this,
                    state.rawResponse.message,
                    Toast.LENGTH_LONG
                ).show()
            }
            is MainActivityState.SuccessMain<*> -> {
                // 👇 Aquí ves la respuesta en Logcat
                Log.d("API_TEST", "✅ Respuesta completa: ${state.response}")

                Toast.makeText(
                    this,
                    "Respuesta: ${state.response.toString()}",
                    Toast.LENGTH_LONG
                ).show()
            }
            is MainActivityState.ShowToast -> {
                Toast.makeText(
                    this,
                    state.message,
                    Toast.LENGTH_LONG
                ).show()
            }
            is MainActivityState.IsLoading -> {
                Log.d("API_TEST", if (state.isLoading) "⏳ Cargando..." else "✅ Finalizó")
            }
        }
    }
}