package io.jadu

import android.app.Application
import io.jadu.di.initializeKoin
import org.koin.android.ext.koin.androidContext

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin {
            androidContext(this@MyApplication)
        }
    }
}