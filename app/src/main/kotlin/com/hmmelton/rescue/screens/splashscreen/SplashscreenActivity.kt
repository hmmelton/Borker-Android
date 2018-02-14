package com.hmmelton.rescue.screens.splashscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hmmelton.rescue.App

class SplashscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create screen's presenter
        val userSession = (application as App).userSession
        val presenter = SplashscreenPresenter(this, userSession)
        presenter.onCreate()

        finish()
    }
}
