package io.jadu.shared

expect class ToastManager {
    fun showShortToast(message: String)
    fun showLongToast(message: String)
}