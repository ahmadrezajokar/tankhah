package com.example.tankhah.core.appmodule

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.internal.DaggerCollections
import javax.inject.Singleton

@HiltAndroidApp
open class Application : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}