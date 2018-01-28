package com.hmmelton.rescue

import android.app.Application
import com.hmmelton.rescue.data.SharedPreferencesTokenStore
import com.hmmelton.rescue.data.UserSession
import com.hmmelton.rescue.http.InstantAdapter
import com.hmmelton.rescue.http.RescueService
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application() {

    val service: RescueService by lazy {
        val moshi = Moshi.Builder().add(InstantAdapter()).build()
        Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
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