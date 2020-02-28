package com.example.zoan

import android.app.Application
import timber.log.Timber

class ZoanApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}