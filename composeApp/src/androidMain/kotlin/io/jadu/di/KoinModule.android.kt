package io.jadu.di

import io.jadu.shared.ToastManager
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val targerModule = module {
    singleOf(::ToastManager)
}