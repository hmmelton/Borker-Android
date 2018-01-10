package com.hmmelton.rescue

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class RescueApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
    }
}