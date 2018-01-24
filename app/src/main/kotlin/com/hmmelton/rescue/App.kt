package com.hmmelton.rescue

import android.app.Application
import com.hmmelton.rescue.data.SharedPreferencesTokenStore
import com.hmmelton.rescue.data.UserSession
import com.hmmelton.rescue.http.RescueService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application() {

    val service: RescueService by lazy {
        Retrofit.Builder()
                .baseUrl(Config.API_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(RescueService::class.java)
    }

    lateinit var userSession: UserSession

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())

        userSession = UserSession(this, SharedPreferencesTokenStore(this))
    }
}