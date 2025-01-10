package io.jadu

import androidx.compose.ui.window.ComposeUIViewController
import io.jadu.di.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initializeKoin() }
) { App() }