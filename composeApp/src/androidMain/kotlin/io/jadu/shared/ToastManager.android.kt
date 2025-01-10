package io.jadu.shared

import android.content.Context
import android.widget.Toast

actual class ToastManager(
    private val context:Context
) {
    actual fun showShortToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    actual fun showLongToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}