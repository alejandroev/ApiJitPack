package co.dito.abako.apijitpack.utils

import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView

fun WebView.onLoadURL(data: String, onSuccess: (String) -> Unit, onFailure: () -> Unit) {
    settings.javaScriptEnabled = true
    loadData(data, "text/html", "UTF-8")
    webChromeClient = object : WebChromeClient() {
        override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
            val text = consoleMessage.message()

            if (text.contains(TRANSACTION_KEY)) {
                onSuccess(text.replace(TRANSACTION_KEY, "").trim())
            } else {
                onFailure()
            }
            return true
        }
    }
}

private const val TRANSACTION_KEY = "TransactionID"