package co.dito.abako.testsample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
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

        if (!Environment.isExternalStorageManager()) {
            //request for the permission
            val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
            val uri: Uri = Uri.fromParts("package", packageName, null)
            intent.data = uri
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        observe()
    }

    private fun observe() {
        viewModel.mState
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { state -> handleStateChange(state) }
            .launchIn(lifecycleScope)
    }

    private fun handleStateChange(state: MainActivityState) {
        /*when (state) {
            is MainActivityState.Init -> Unit
            is MainActivityState.ErrorMain -> Toast.makeText(
                this,
                state.rawResponse.message,
                Toast.LENGTH_LONG
            ).show()

            is MainActivityState.SuccessMain -> Toast.makeText(
                this,
                state.response,
                Toast.LENGTH_LONG
            ).show()
            is MainActivityState.ShowToast -> Toast.makeText(
                this,
                state.message,
                Toast.LENGTH_LONG
            ).show()
            is MainActivityState.IsLoading -> Toast.makeText(
                this,
                if(state.isLoading) "Cargando" else "Ya no" ,
                Toast.LENGTH_LONG
            ).show()
        }*/
    }
}